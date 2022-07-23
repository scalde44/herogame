package co.com.sofkau.api.game.handler;

import co.com.sofkau.api.helper.HandlerBase;
import co.com.sofkau.model.game.commands.CreateGameCommand;
import co.com.sofkau.model.generic.EventStoreRepository;
import co.com.sofkau.model.generic.StoredEvent;
import co.com.sofkau.usecase.game.CreateGameUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class CreateGameHandler extends HandlerBase {
    private final CreateGameUseCase useCase;

    public CreateGameHandler(EventStoreRepository repository, StoredEvent.EventSerializer eventSerializer, CreateGameUseCase useCase) {
        super(repository, eventSerializer);
        this.useCase = useCase;
    }

    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(CreateGameCommand.class)
                .flatMapMany(command -> this.useCase.apply(command))
                .flatMap(domainEvent -> emit(Mono.just(domainEvent)))
                .then(ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .build());
    }
}
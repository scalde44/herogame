package co.com.sofkau.api.card.handler;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.usecase.card.createcard.CreateCardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreateCardHandler {
    private final CreateCardUseCase useCase;

    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(Card.class)
                .flatMap(this.useCase::apply)
                .flatMap(card -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(card)
                );
    }
}

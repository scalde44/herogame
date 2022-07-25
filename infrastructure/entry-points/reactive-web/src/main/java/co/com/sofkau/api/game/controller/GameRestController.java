package co.com.sofkau.api.game.controller;

import co.com.sofkau.api.helper.HandlerBase;
import co.com.sofkau.model.game.commands.CreateGameCommand;
import co.com.sofkau.model.game.commands.StartGameCommand;
import co.com.sofkau.model.generic.EventBus;
import co.com.sofkau.model.generic.EventStoreRepository;
import co.com.sofkau.model.generic.StoredEvent;
import co.com.sofkau.usecase.game.CreateGameUseCase;
import co.com.sofkau.usecase.game.StartGameUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/game")
public class GameRestController extends HandlerBase {
    private final StartGameUseCase startGameUseCase;
    private final CreateGameUseCase createGameUseCase;

    public GameRestController(EventStoreRepository repository, StoredEvent.EventSerializer eventSerializer, EventBus eventBus, StartGameUseCase startGameUseCase, CreateGameUseCase createGameUseCase) {
        super(repository, eventSerializer, eventBus);
        this.startGameUseCase = startGameUseCase;
        this.createGameUseCase = createGameUseCase;
    }

    @PostMapping("/create")
    public Mono<String> createGame(@RequestBody CreateGameCommand command) {
        return Mono.just(command)
                .flatMapMany(this.createGameUseCase::apply)
                .flatMap(domainEvent -> emit(Mono.just(domainEvent)))
                .then(Mono.just(command.getGameId()));
    }

    @PostMapping("/start")
    public Mono<String> startGame(@RequestBody StartGameCommand command) {
        return Mono.just(command)
                .flatMapMany(this.startGameUseCase::apply)
                .flatMap(domainEvent -> emit(Mono.just(domainEvent)))
                .then(Mono.just(command.getGameId()));
    }
}

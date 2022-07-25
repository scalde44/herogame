package co.com.sofkau.usecase.game;

import co.com.sofkau.model.game.Game;
import co.com.sofkau.model.game.commands.AddCardToBoardCommand;
import co.com.sofkau.model.game.identities.GameId;
import co.com.sofkau.model.game.identities.PlayerId;
import co.com.sofkau.model.game.values.GameCard;
import co.com.sofkau.model.generic.DomainEvent;
import co.com.sofkau.model.generic.EventStoreRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@RequiredArgsConstructor
public class AddCardToBoardUseCase implements Function<AddCardToBoardCommand, Flux<DomainEvent>> {
    private final EventStoreRepository repository;

    @Override
    public Flux<DomainEvent> apply(AddCardToBoardCommand command) {
        return this.repository.getEventsBy("game", command.getGameId()).collectList()
                .flatMapIterable(events -> {
                    var game = Game.from(GameId.of(command.getGameId()), events);
                    game.addCardToBoard(PlayerId.of(command.getPlayerId()), new GameCard(command.getCardId(), Boolean.TRUE));
                    return game.getUncommittedChanges();
                });
    }
}

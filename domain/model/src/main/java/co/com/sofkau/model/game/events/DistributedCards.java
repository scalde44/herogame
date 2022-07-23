package co.com.sofkau.model.game.events;

import co.com.sofkau.model.game.identities.PlayerId;
import co.com.sofkau.model.game.values.GameCard;
import co.com.sofkau.model.generic.DomainEvent;

import java.util.Set;

public class DistributedCards extends DomainEvent {
    private final PlayerId playerId;
    private final Set<GameCard> gameCards;

    public DistributedCards(PlayerId playerId, Set<GameCard> gameCards) {
        super("herogame.game.DistributedCards");
        this.playerId = playerId;
        this.gameCards = gameCards;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public Set<GameCard> getGameCards() {
        return gameCards;
    }
}

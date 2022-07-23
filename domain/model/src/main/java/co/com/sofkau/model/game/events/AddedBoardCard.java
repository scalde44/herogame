package co.com.sofkau.model.game.events;

import co.com.sofkau.model.game.identities.PlayerId;
import co.com.sofkau.model.game.values.GameCard;
import co.com.sofkau.model.generic.DomainEvent;

public class AddedBoardCard extends DomainEvent {
    public static final String EVENT_TYPE = "game.AddedBoardCard";
    private final PlayerId playerId;
    private final GameCard gameCard;

    public AddedBoardCard(PlayerId playerId, GameCard gameCard) {
        super(EVENT_TYPE);
        this.playerId = playerId;
        this.gameCard = gameCard;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public GameCard getGameCard() {
        return gameCard;
    }
}

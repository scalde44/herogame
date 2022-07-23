package co.com.sofkau.model.game.events;

import co.com.sofkau.model.game.identities.PlayerId;
import co.com.sofkau.model.game.values.GameCard;
import co.com.sofkau.model.generic.DomainEvent;

public class AddedBoardCard extends DomainEvent {
    private final PlayerId playerId;
    private final GameCard gameCard;

    public AddedBoardCard(PlayerId playerId, GameCard gameCard) {
        super("herogame.game.AddedBoardCard");
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

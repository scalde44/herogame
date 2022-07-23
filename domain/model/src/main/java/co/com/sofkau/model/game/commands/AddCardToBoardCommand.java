package co.com.sofkau.model.game.commands;

import co.com.sofkau.model.game.identities.GameId;
import co.com.sofkau.model.game.identities.PlayerId;
import co.com.sofkau.model.game.values.GameCard;
import co.com.sofkau.model.generic.Command;

public class AddCardToBoardCommand extends Command {
    private GameId gameId;
    private PlayerId playerId;
    private GameCard gameCard;

    public AddCardToBoardCommand(GameId gameId, PlayerId playerId, GameCard gameCard) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.gameCard = gameCard;
    }

    public GameId getGameId() {
        return gameId;
    }

    public void setGameId(GameId gameId) {
        this.gameId = gameId;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public void setPlayerId(PlayerId playerId) {
        this.playerId = playerId;
    }

    public GameCard getGameCard() {
        return gameCard;
    }

    public void setGameCard(GameCard gameCard) {
        this.gameCard = gameCard;
    }
}

package co.com.sofkau.model.game.commands;

import co.com.sofkau.model.game.identities.GameId;
import co.com.sofkau.model.generic.Command;

public class EmptyBoardCommand extends Command {
    private GameId gameId;

    public EmptyBoardCommand(GameId gameId) {
        this.gameId = gameId;
    }

    public GameId getGameId() {
        return gameId;
    }

    public void setGameId(GameId gameId) {
        this.gameId = gameId;
    }
}

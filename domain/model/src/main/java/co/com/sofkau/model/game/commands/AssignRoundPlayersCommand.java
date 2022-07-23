package co.com.sofkau.model.game.commands;

import co.com.sofkau.model.game.identities.GameId;
import co.com.sofkau.model.game.identities.RoundId;
import co.com.sofkau.model.generic.Command;

public class AssignRoundPlayersCommand extends Command {
    private GameId gameId;
    private RoundId roundId;

    public AssignRoundPlayersCommand(GameId gameId, RoundId roundId) {
        this.gameId = gameId;
        this.roundId = roundId;
    }

    public GameId getGameId() {
        return gameId;
    }

    public void setGameId(GameId gameId) {
        this.gameId = gameId;
    }

    public RoundId getRoundId() {
        return roundId;
    }

    public void setRoundId(RoundId roundId) {
        this.roundId = roundId;
    }
}

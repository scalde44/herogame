package co.com.sofkau.model.game.commands;

import co.com.sofkau.model.game.factories.CardsByPlayerFactory;
import co.com.sofkau.model.game.identities.GameId;
import co.com.sofkau.model.generic.Command;

public class StartGameCommand extends Command {
    private GameId gameId;
    private CardsByPlayerFactory cardsByPlayerFactory;

    public StartGameCommand(GameId gameId, CardsByPlayerFactory cardsByPlayerFactory) {
        this.gameId = gameId;
        this.cardsByPlayerFactory = cardsByPlayerFactory;
    }

    public GameId getGameId() {
        return gameId;
    }

    public void setGameId(GameId gameId) {
        this.gameId = gameId;
    }

    public CardsByPlayerFactory getCardsByPlayerFactory() {
        return cardsByPlayerFactory;
    }

    public void setCardsByPlayerFactory(CardsByPlayerFactory cardsByPlayerFactory) {
        this.cardsByPlayerFactory = cardsByPlayerFactory;
    }
}

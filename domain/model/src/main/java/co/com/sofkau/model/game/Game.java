package co.com.sofkau.model.game;
import co.com.sofkau.model.game.identities.GameId;
import co.com.sofkau.model.generic.AggregateEvent;

import java.util.Set;

public class Game extends AggregateEvent<GameId> {
    protected Board board;
    protected Set<Player> players;
    protected Set<Round> rounds;

    public Game(GameId entityId) {
        super(entityId);
    }
}

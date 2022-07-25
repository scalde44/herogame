package co.com.sofkau.model.game.events;

import co.com.sofkau.model.game.identities.PlayerId;
import co.com.sofkau.model.game.identities.RoundId;
import co.com.sofkau.model.generic.DomainEvent;

public class FinishedRound extends DomainEvent {
    public static final String EVENT_TYPE = "game.FinishedRound";
    private final RoundId roundId;
    private final PlayerId winner;

    public FinishedRound(RoundId roundId, PlayerId winner) {
        super(EVENT_TYPE);
        this.roundId = roundId;
        this.winner = winner;
    }

    public RoundId getRoundId() {
        return roundId;
    }

    public PlayerId getWinner() {
        return winner;
    }
}

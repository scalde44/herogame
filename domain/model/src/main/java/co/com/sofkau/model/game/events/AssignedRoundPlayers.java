package co.com.sofkau.model.game.events;

import co.com.sofkau.model.game.identities.RoundId;
import co.com.sofkau.model.generic.DomainEvent;

public class AssignedRoundPlayers extends DomainEvent {
    public static final String EVENT_TYPE = "game.assignedRoundPlayers";
    private final RoundId roundId;

    public AssignedRoundPlayers(RoundId roundId) {
        super(EVENT_TYPE);
        this.roundId = roundId;
    }

    public RoundId getRoundId() {
        return roundId;
    }
}

package co.com.sofkau.model.game.events;

import co.com.sofkau.model.game.identities.RoundId;
import co.com.sofkau.model.generic.DomainEvent;

public class AssignedRoundPlayers extends DomainEvent {
    private final RoundId roundId;

    public AssignedRoundPlayers(RoundId roundId) {
        super("herogame.game.assignedRoundPlayers");
        this.roundId = roundId;
    }

    public RoundId getRoundId() {
        return roundId;
    }
}

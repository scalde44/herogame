package co.com.sofkau.model.game.events;

import co.com.sofkau.model.game.identities.RoundId;
import co.com.sofkau.model.generic.DomainEvent;

public class CreateRound extends DomainEvent {
    public static final String EVENT_TYPE = "game.CreateRound";
    private final RoundId roundId;

    public CreateRound(RoundId roundId) {
        super(EVENT_TYPE);
        this.roundId = roundId;
    }

    public RoundId getRoundId() {
        return roundId;
    }
}

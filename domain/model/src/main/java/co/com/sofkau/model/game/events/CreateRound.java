package co.com.sofkau.model.game.events;

import co.com.sofkau.model.game.identities.RoundId;
import co.com.sofkau.model.generic.DomainEvent;

public class CreateRound extends DomainEvent {
    private final RoundId roundId;

    public CreateRound(RoundId roundId) {
        super("herogame.game.CreateRound");
        this.roundId = roundId;
    }

    public RoundId getRoundId() {
        return roundId;
    }
}

package co.com.sofkau.model.game.events;

import co.com.sofkau.model.game.identities.PlayerId;
import co.com.sofkau.model.generic.DomainEvent;

public class AddedPlayer extends DomainEvent {
    private final PlayerId identity;
    private final String userId;

    public AddedPlayer(PlayerId identity, String userId) {
        super("herogame.game.AddedPlayer");
        this.identity = identity;
        this.userId = userId;
    }

    public PlayerId getIdentity() {
        return identity;
    }

    public String getUserId() {
        return userId;
    }
}

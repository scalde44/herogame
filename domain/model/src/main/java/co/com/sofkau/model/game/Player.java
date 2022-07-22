package co.com.sofkau.model.game;

import co.com.sofkau.model.game.identities.PlayerId;
import co.com.sofkau.model.generic.Entity;

public class Player extends Entity<PlayerId> {
    
    public Player(PlayerId entityId) {
        super(entityId);
    }
}

package co.com.sofkau.model.game.events;

import co.com.sofkau.model.game.values.DateGame;
import co.com.sofkau.model.generic.DomainEvent;

public class CreatedGame extends DomainEvent {
    private final DateGame dateGame;

    public CreatedGame(DateGame dateGame) {
        super("herogame.game.CreatedGame");
        this.dateGame = dateGame;
    }

    public DateGame getDateGame() {
        return dateGame;
    }
}

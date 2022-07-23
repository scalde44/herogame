package co.com.sofkau.model.game.events;

import co.com.sofkau.model.game.identities.BoardId;
import co.com.sofkau.model.generic.DomainEvent;

public class CreatedBoard extends DomainEvent {
    private final BoardId boardId;

    public CreatedBoard(BoardId boardId) {
        super("herogame.game.CreatedBoard");
        this.boardId = boardId;
    }

    public BoardId getBoardId() {
        return boardId;
    }
}

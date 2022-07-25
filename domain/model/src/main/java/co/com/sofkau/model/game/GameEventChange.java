package co.com.sofkau.model.game;

import co.com.sofkau.model.game.events.*;
import co.com.sofkau.model.generic.EventChange;

import java.util.HashSet;
import java.util.Objects;

public class GameEventChange extends EventChange {
    public GameEventChange(Game game) {
        apply((CreatedGame event) -> {
            game.dateGame = event.getDateGame();
            game.players = new HashSet<>();
            game.rounds = new HashSet<>();
            game.isPlaying = Boolean.FALSE;
        });

        apply((AddedPlayer event) -> {
            game.players.add(new Player(event.getIdentity(), event.getUserId()));
        });

        apply((CreatedBoard event) -> {
            game.board = new Board(event.getBoardId());
        });
        apply((GameStarted event) -> {
            game.isPlaying = Boolean.TRUE;
        });
        apply((DistributedCards event) -> {
            game.getPlayer(event.getPlayerId())
                    .ifPresent(player ->
                            event.getGameCards().forEach(player::addCard)
                    );
        });

        apply((CreatedRound event) -> {
            game.rounds.add(new Round(event.getRoundId(), event.getRoundNumber()));
        });

        apply((AssignedRoundPlayers event) -> {
            game.rounds.stream()
                    .filter(round -> Objects.equals(round.identity(), event.getRoundId()))
                    .findFirst()
                    .ifPresent(round ->
                            event.getPlayers().forEach(round::addPlayer));
        });

        apply((AddedBoardCard event) -> {
            game.board.addCard(event.getPlayerId(), event.getGameCard());
        });

        apply((CleanedBoard event) -> {
            game.board.clearAll();
        });

    }
}

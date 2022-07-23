package co.com.sofkau.model.game;

import co.com.sofkau.model.game.events.*;
import co.com.sofkau.model.game.values.RoundNumber;
import co.com.sofkau.model.generic.EventChange;

import java.util.HashSet;

public class GameEventChange extends EventChange {
    public GameEventChange(Game game) {
        apply((CreatedGame event) -> {
            game.dateGame = event.getDateGame();
            game.players = new HashSet<>();
            game.rounds = new HashSet<>();
        });

        apply((AddedPlayer event) -> {
            game.players.add(new Player(event.getIdentity(), event.getUserId()));
        });

        apply((CreatedBoard event) -> {
            game.board = new Board(event.getBoardId());
        });

        apply((DistributedCards event) -> {
            game.getPlayer(event.getPlayerId())
                    .ifPresent(player ->
                            event.getGameCards().forEach(player::addCard)
                    );
        });

        apply((CreateRound event) -> {
            game.rounds.add(new Round(event.getRoundId(), new RoundNumber(game.rounds.size() + 1)));
        });

        apply((AssignedRoundPlayers event)-> {
            game.getRound(event.getRoundId())
                    .ifPresent(round ->
                            game.getPlayersToRound().forEach(round::addPlayer));
        });

        apply((AddedBoardCard event) -> {
            game.board.addCard(event.getPlayerId(), event.getGameCard());
        });

        apply((CleanedBoard event) -> {
            game.board.clearAll();
        });

    }
}

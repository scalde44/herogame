package co.com.sofkau.model.game;

import co.com.sofkau.model.game.events.*;
import co.com.sofkau.model.game.factories.CardsByPlayerFactory;
import co.com.sofkau.model.game.factories.PlayerFactory;
import co.com.sofkau.model.game.identities.BoardId;
import co.com.sofkau.model.game.identities.GameId;
import co.com.sofkau.model.game.identities.PlayerId;
import co.com.sofkau.model.game.identities.RoundId;
import co.com.sofkau.model.game.values.DateGame;
import co.com.sofkau.model.game.values.GameCard;
import co.com.sofkau.model.game.values.RoundNumber;
import co.com.sofkau.model.generic.AggregateEvent;
import co.com.sofkau.model.generic.DomainEvent;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Game extends AggregateEvent<GameId> {
    protected Board board;
    protected Set<Player> players;
    protected Set<Round> rounds;
    protected DateGame dateGame;
    protected Boolean isPlaying;

    public Game(GameId gameId, PlayerFactory playerFactory, DateGame dateGame) {
        super(gameId);
        subscribe(new GameEventChange(this));
        appendChange(new CreatedGame(dateGame)).apply();
        playerFactory.players()
                .forEach(player ->
                        appendChange(new AddedPlayer(player.identity(), player.userId())).apply()
                );
        appendChange(new CreatedBoard(new BoardId())).apply();
    }

    private Game(GameId gameId) {
        super(gameId);
        subscribe(new GameEventChange(this));
    }

    public static Game from(GameId gameId, List<DomainEvent> events) {
        var game = new Game(gameId);
        events.forEach(game::applyEvent);
        return game;
    }

    public void startGame() {
        appendChange(new GameStarted(this.entityId)).apply();
    }

    public void distributeCards(CardsByPlayerFactory cardsByPlayerFactory) {
        cardsByPlayerFactory.cardsByPlayer()
                .forEach((playerId, gameCards) ->
                        appendChange(new DistributedCards(playerId, gameCards)).apply()
                );
    }

    public void createRound(RoundId roundId) {
        appendChange(new CreatedRound(this.entityId, roundId, new RoundNumber(rounds.size() + 1))).apply();
    }

    public void assignRoundPlayers(RoundId roundId) {
        appendChange(new AssignedRoundPlayers(roundId, getPlayersToRound())).apply();
    }

    public void addCardToBoard(PlayerId playerId, GameCard gameCard) {
        appendChange(new AddedBoardCard(playerId, gameCard)).apply();
    }

    public void emptyBoard() {
        appendChange(new CleanedBoard()).apply();
    }

    public Optional<Player> getPlayer(PlayerId playerId) {
        return this.players.stream()
                .filter(player ->
                        Objects.equals(player.identity(), playerId))
                .findFirst();
    }

    private Set<PlayerId> getPlayersToRound() {
        return players.stream()
                .filter(player -> player.gameCards().size() > 0)
                .map(Player::identity)
                .collect(Collectors.toSet());
    }

    public Set<Player> players() {
        return Set.copyOf(players);
    }
}

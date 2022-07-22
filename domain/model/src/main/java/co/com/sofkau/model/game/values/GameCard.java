package co.com.sofkau.model.game.values;

import co.com.sofkau.model.generic.ValueObject;

import java.util.Objects;

public class GameCard implements ValueObject<GameCard.Properties> {
    private final String cardId;
    private final Boolean isHidden;

    public GameCard(String cardId, Boolean isHidden) {
        this.cardId = Objects.requireNonNull(cardId);
        this.isHidden = Objects.requireNonNull(isHidden);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String cardId() {
                return cardId;
            }

            @Override
            public Boolean isHidden() {
                return isHidden;
            }
        };
    }

    public interface Properties {
        String cardId();

        Boolean isHidden();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameCard gameCard = (GameCard) o;
        return cardId.equals(gameCard.cardId) && isHidden.equals(gameCard.isHidden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, isHidden);
    }
}

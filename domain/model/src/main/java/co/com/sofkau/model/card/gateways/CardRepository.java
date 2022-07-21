package co.com.sofkau.model.card.gateways;

import co.com.sofkau.model.card.Card;
import reactor.core.publisher.Mono;

public interface CardRepository {
    Mono<Card> save(Card card);
}

package co.com.sofkau.usecase.card;

import co.com.sofkau.model.card.Card;
import co.com.sofkau.model.card.gateways.CardRepository;
import co.com.sofkau.model.card.values.Image;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@RequiredArgsConstructor
public class UpdateImageCardUseCase implements BiFunction<Image, String, Mono<Card>> {
    private final CardRepository cardRepository;

    @Override
    public Mono<Card> apply(Image image, String id) {
        return this.cardRepository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("Card no encontrada")))
                .map(card -> {
                    card.updateImage(image);
                    return card;
                })
                .flatMap(this.cardRepository::save);
    }
}

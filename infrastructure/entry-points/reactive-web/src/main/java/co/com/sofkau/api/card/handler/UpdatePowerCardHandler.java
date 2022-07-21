package co.com.sofkau.api.card.handler;

import co.com.sofkau.api.card.dto.PowerDTO;
import co.com.sofkau.api.card.helper.MapperCard;
import co.com.sofkau.model.card.values.Power;
import co.com.sofkau.usecase.card.UpdatePowerCardUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UpdatePowerCardHandler {
    private final UpdatePowerCardUseCase useCase;
    private final MapperCard mapperCard;

    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(PowerDTO.class)
                .zipWith(Mono.just(serverRequest.pathVariable("id")))
                .flatMap(objects ->
                        this.useCase.apply(new Power(objects.getT1().getPower()), objects.getT2())
                )
                .map(this.mapperCard.mapCardToDTO())
                .flatMap(card -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(card)
                );
    }
}

package co.com.sofkau.api.card.handler;

import co.com.sofkau.api.card.dto.CardDTO;
import co.com.sofkau.api.card.helper.MapperCard;
import co.com.sofkau.model.card.Card;
import co.com.sofkau.usecase.card.CardByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CardByIdHandler {

    private final CardByIdUseCase cardByIdUseCase;
    private final MapperCard mapperCard;

    public Mono<ServerResponse> cardById(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(this.cardByIdUseCase.cardById(id)
                .map(this.mapperCard.mapToDTO()), CardDTO.class));
    }
}

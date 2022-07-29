package co.com.sofkau.api.user.handler;

import co.com.sofkau.api.user.dto.UserDTO;
import co.com.sofkau.api.user.helper.MapperUser;
import co.com.sofkau.usecase.user.FindByEmailUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FindByEmailUserHandler {

    private final FindByEmailUserUseCase useCase;
    private final MapperUser mapperUser;

    public Mono<ServerResponse> findByEmail(ServerRequest serverRequest) {
        var email = serverRequest.pathVariable("email");
        return ServerResponse.ok()
                .body(BodyInserters.fromPublisher(this.useCase.apply(email)
                        .map(this.mapperUser.mapToDTO()), UserDTO.class));
    }

}
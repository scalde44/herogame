package co.com.sofkau.api.game.route;

import co.com.sofkau.api.game.handler.CreateGameHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterGameRest {

    @Bean
    public RouterFunction<ServerResponse> routerCreateGameFunction(CreateGameHandler handler) {
        return route(POST("/api/v1/creategame"), handler::create);
    }
}
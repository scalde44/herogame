package co.com.sofkau.api.card.route;

import co.com.sofkau.api.card.handler.CreateCardHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerCreateCardFunction(CreateCardHandler handler) {
        return route(POST("/api/v1/card"), handler::create);
    }
}

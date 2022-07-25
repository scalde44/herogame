package co.com.sofkau.rabbit.config;

import co.com.sofkau.model.game.events.CreatedRound;
import co.com.sofkau.model.game.events.GameStarted;
import co.com.sofkau.usecase.game.AssignRoundPlayersUseCase;
import co.com.sofkau.usecase.game.CreateRoundUseCase;
import co.com.sofkau.usecase.game.DistributeCardsUseCase;
import co.com.sofkau.usecase.generic.UseCaseWrap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.Set;

@Configuration
public class EventListenerConfig {
    @Bean
    public Set<UseCaseWrap> useCasesForListener(CreateRoundUseCase createRoundUseCase,
                                                 DistributeCardsUseCase distributeCardsUseCase,
                                                 AssignRoundPlayersUseCase assignRoundPlayersUseCase) {
        return Set.of(
                new UseCaseWrap(createRoundUseCase, GameStarted.EVENT_TYPE),
                new UseCaseWrap(distributeCardsUseCase, GameStarted.EVENT_TYPE),
                new UseCaseWrap(assignRoundPlayersUseCase, CreatedRound.EVENT_TYPE)
        );
    }
}

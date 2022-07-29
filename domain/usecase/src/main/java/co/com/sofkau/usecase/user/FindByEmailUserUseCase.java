package co.com.sofkau.usecase.user;

import co.com.sofkau.model.user.User;
import co.com.sofkau.model.user.gateways.UserRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class FindByEmailUserUseCase implements Function<String, Mono<User>> {

    private final UserRepository userRepository;

    @Override
    public Mono<User> apply(String email) {
        return userRepository.findByEmail(email);
    }
}

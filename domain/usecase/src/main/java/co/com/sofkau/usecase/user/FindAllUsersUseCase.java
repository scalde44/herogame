package co.com.sofkau.usecase.user;

import co.com.sofkau.model.user.User;
import co.com.sofkau.model.user.gateways.UserRepository;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

public class FindAllUsersUseCase implements Supplier<Flux<User>> {

    private static UserRepository userRepository;
    @Override
    public Flux<User> get() {
        return this.userRepository.findAll();
    }
}

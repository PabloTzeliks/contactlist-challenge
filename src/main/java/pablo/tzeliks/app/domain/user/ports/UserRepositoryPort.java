package pablo.tzeliks.app.domain.user.ports;

import pablo.tzeliks.app.domain.user.model.User;

import java.util.Optional;

public interface UserRepositoryPort {

    User save(User user);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}

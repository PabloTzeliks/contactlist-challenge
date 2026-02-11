package pablo.tzeliks.app.infrastructure.persistence.user.repository;

import pablo.tzeliks.app.domain.user.model.User;
import pablo.tzeliks.app.domain.user.ports.UserRepositoryPort;
import pablo.tzeliks.app.infrastructure.persistence.user.entity.UserEntity;
import pablo.tzeliks.app.infrastructure.persistence.user.mapper.UserMapper;

import java.util.Optional;

public class UserRepositoryAdapter implements UserRepositoryPort {

    JpaUserRepository repository;
    UserMapper mapper;

    public UserRepositoryAdapter(JpaUserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User save(User user) {

        UserEntity entity = mapper.toEntity(user);

        if (user.getCreatedAt().equals(user.getUpdatedAt())) {
            entity.markAsNew();
        }

        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username)
                .map(mapper::toDomain);
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }
}

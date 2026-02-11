package pablo.tzeliks.app.infrastructure.persistence.user.mapper;

import org.springframework.stereotype.Component;
import pablo.tzeliks.app.domain.user.domain.User;
import pablo.tzeliks.app.infrastructure.persistence.user.entity.UserEntity;

import java.util.HashSet;

@Component
public class UserMapper {

    public UserEntity toEntity(User domainUser) {
        if (domainUser == null) return null;

        return new UserEntity(
                domainUser.getId(),
                domainUser.getUsername(),
                domainUser.getPassword(),
                domainUser.getRoles(),
                domainUser.getCreatedAt(),
                domainUser.getUpdatedAt()
        );
    }

    public User toDomain(UserEntity entity) {
        if (entity == null) return null;

        return new User(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword(),
                new HashSet<>(entity.getRoles()),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}

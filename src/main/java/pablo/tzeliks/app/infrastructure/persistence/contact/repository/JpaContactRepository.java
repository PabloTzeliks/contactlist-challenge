package pablo.tzeliks.app.infrastructure.persistence.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pablo.tzeliks.app.domain.contact.model.Contact;
import pablo.tzeliks.app.infrastructure.persistence.contact.entity.ContactEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JpaContactRepository extends JpaRepository<ContactEntity, UUID> {

    List<ContactEntity> findAllByOwnerId(UUID ownerId);

    Optional<ContactEntity> findByIdAndOwnerId(UUID id, UUID ownerId);

    boolean existsByOwnerIdAndPhoneNumber(UUID ownerId, String phoneNumber);
}

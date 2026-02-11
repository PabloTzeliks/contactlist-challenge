package pablo.tzeliks.app.infrastructure.persistence.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pablo.tzeliks.app.domain.contact.model.Contact;
import pablo.tzeliks.app.infrastructure.persistence.contact.entity.ContactEntity;

import java.util.Optional;
import java.util.UUID;

public interface JpaContactRepository extends JpaRepository<ContactEntity, UUID> {

    Optional<ContactEntity> findContactByPhoneNumber(String number);
}

package pablo.tzeliks.app.domain.contact.ports;

import pablo.tzeliks.app.domain.contact.model.Contact;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactRepositoryPort {

    Contact save(Contact contact);

    Optional<Contact> findById(UUID id);

    List<Contact> findAllByOwnerId(UUID ownerId);

    Optional<Contact> findByIdAndOwnerId(UUID id, UUID ownerId);

    boolean existsByOwnerIdAndPhoneNumber(UUID ownerId, String phoneNumber);
}

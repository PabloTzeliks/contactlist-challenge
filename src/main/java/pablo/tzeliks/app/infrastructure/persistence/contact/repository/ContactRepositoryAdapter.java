package pablo.tzeliks.app.infrastructure.persistence.contact.repository;

import org.springframework.stereotype.Repository;
import pablo.tzeliks.app.domain.contact.model.Contact;
import pablo.tzeliks.app.domain.contact.ports.ContactRepositoryPort;
import pablo.tzeliks.app.infrastructure.persistence.contact.mapper.ContactMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ContactRepositoryAdapter implements ContactRepositoryPort {

    JpaContactRepository repository;
    ContactMapper mapper;

    public ContactRepositoryAdapter(JpaContactRepository repository, ContactMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Contact save(Contact contact) {

        return mapper.toDomain(mapper.toEntity(contact));
    }

    @Override
    public Optional<Contact> findById(UUID id) {

        return repository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Contact> findAllByOwnerId(UUID ownerId) {

        return repository.findAllByOwnerId(ownerId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Contact> findByIdAndOwnerId(UUID id, UUID ownerId) {

        return repository.findByIdAndOwnerId(id, ownerId)
                .map(mapper::toDomain);
    }

    @Override
    public boolean existsByOwnerIdAndPhoneNumber(UUID ownerId, String phoneNumber) {

        return repository.existsByOwnerIdAndPhoneNumber(ownerId, phoneNumber);
    }
}

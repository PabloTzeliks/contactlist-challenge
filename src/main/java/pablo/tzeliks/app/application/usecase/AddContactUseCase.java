package pablo.tzeliks.app.application.usecase;

import org.springframework.stereotype.Service;
import pablo.tzeliks.app.application.dto.ContactResponse;
import pablo.tzeliks.app.application.dto.CreateContactRequest;
import pablo.tzeliks.app.application.mapper.ContactDtoMapper;
import pablo.tzeliks.app.domain.entity.Contact;
import pablo.tzeliks.app.domain.ports.ContactRepositoryPort;

import java.util.UUID;

@Service
public class AddContactUseCase {

    private ContactDtoMapper mapper;
    private ContactRepositoryPort repository;

    public AddContactUseCase(ContactDtoMapper mapper, ContactRepositoryPort repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public ContactResponse execute(CreateContactRequest request) {

        Contact contact = mapper.toEntity(request);

        Contact saved = repository.save(contact);

        return mapper.toDto(saved);
    }
}

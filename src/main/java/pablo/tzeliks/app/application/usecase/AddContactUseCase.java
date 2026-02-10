package pablo.tzeliks.app.application.usecase;

import org.springframework.stereotype.Service;
import pablo.tzeliks.app.application.dto.ContactResponse;
import pablo.tzeliks.app.application.dto.CreateContactRequest;
import pablo.tzeliks.app.application.mapper.ContactDtoMapper;
import pablo.tzeliks.app.domain.entity.Contact;
import pablo.tzeliks.app.domain.ports.ContactRepositoryPort;
import pablo.tzeliks.app.domain.ports.PhoneNumberFilterPort;

import java.util.UUID;

@Service
public class AddContactUseCase {

    private ContactDtoMapper mapper;
    private ContactRepositoryPort repository;
    private PhoneNumberFilterPort phoneNumberFilter;

    public AddContactUseCase(ContactDtoMapper mapper, ContactRepositoryPort repository, PhoneNumberFilterPort phoneNumberFilter) {
        this.mapper = mapper;
        this.repository = repository;
        this.phoneNumberFilter = phoneNumberFilter;
    }

    public ContactResponse execute(CreateContactRequest request) {

        UUID id = UUID.randomUUID();

        Contact contact = mapper.toEntity(request, id);

        return mapper.toDto(repository.save(contact));
    }
}

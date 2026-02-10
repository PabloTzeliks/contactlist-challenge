package pablo.tzeliks.app.application.usecase;

import pablo.tzeliks.app.application.dto.ContactResponse;
import pablo.tzeliks.app.application.dto.CreateContactRequest;
import pablo.tzeliks.app.application.mapper.ContactDtoMapper;
import pablo.tzeliks.app.domain.ports.ContactRepositoryPort;
import pablo.tzeliks.app.domain.ports.PhoneNumberFilterPort;

import java.util.UUID;

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


    }
}

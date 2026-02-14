package pablo.tzeliks.app.application.contact.usecase;

import pablo.tzeliks.app.application.contact.dto.ContactResponse;
import pablo.tzeliks.app.application.contact.mapper.ContactDtoMapper;
import pablo.tzeliks.app.domain.contact.ports.ContactRepositoryPort;

public class UpdateContactUseCase {

    private final ContactDtoMapper mapper;
    private final ContactRepositoryPort repositoryPort;

    public UpdateContactUseCase(ContactDtoMapper mapper, ContactRepositoryPort repositoryPort) {
        this.mapper = mapper;
        this.repositoryPort = repositoryPort;
    }

    public ContactResponse execute()
}

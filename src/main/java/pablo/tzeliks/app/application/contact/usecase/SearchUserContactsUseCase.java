package pablo.tzeliks.app.application.contact.usecase;

import org.springframework.stereotype.Service;
import pablo.tzeliks.app.application.contact.dto.ContactResponse;
import pablo.tzeliks.app.application.contact.mapper.ContactDtoMapper;
import pablo.tzeliks.app.domain.contact.ports.ContactRepositoryPort;

import java.util.List;
import java.util.UUID;

@Service
public class SearchUserContactsUseCase {

    private final ContactDtoMapper mapper;
    private final ContactRepositoryPort repositoryPort;

    public SearchUserContactsUseCase(ContactDtoMapper mapper, ContactRepositoryPort repositoryPort) {
        this.mapper = mapper;
        this.repositoryPort = repositoryPort;
    }

    public List<ContactResponse> execute(UUID userId) {

        return repositoryPort.findAllByOwnerId(userId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}

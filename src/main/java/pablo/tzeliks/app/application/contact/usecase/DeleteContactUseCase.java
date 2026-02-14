package pablo.tzeliks.app.application.contact.usecase;

import org.springframework.stereotype.Service;
import pablo.tzeliks.app.application.contact.mapper.ContactDtoMapper;
import pablo.tzeliks.app.domain.contact.ports.ContactRepositoryPort;
import pablo.tzeliks.app.domain.exception.ResourceNotFoundException;

import java.util.UUID;

@Service
public class DeleteContactUseCase {

    private final ContactRepositoryPort repositoryPort;

    public DeleteContactUseCase(ContactRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    public void execute(UUID id, UUID ownerId) {

        var contact = repositoryPort.findByIdAndOwnerId(id, ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado."));

        repositoryPort.delete(contact);
    }
}

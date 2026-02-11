package pablo.tzeliks.app.infrastructure.persistence.contact.mapper;

import org.springframework.stereotype.Component;
import pablo.tzeliks.app.domain.contact.model.Contact;
import pablo.tzeliks.app.infrastructure.persistence.contact.entity.ContactEntity;

@Component
public class ContactMapper {

    public ContactEntity toEntity(Contact domain) {
        if (domain == null) return null;

        return new ContactEntity(
                domain.getId(),
                domain.getOwnerId(),
                domain.getName(),
                domain.getPhoneNumber(),
                domain.getCreatedAt(),
                domain.getUpdatedAt()
        );
    }

    public Contact toDomain(ContactEntity entity) {
        if (entity == null) return null;

        return new Contact(
                entity.getId(),
                entity.getOwnerId(),
                entity.getName(),
                entity.getPhoneNumber(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}

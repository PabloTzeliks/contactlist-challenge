package pablo.tzeliks.app.domain.contact.exception;

public class ResourceAlreadyExistsException extends BusinessRuleException {
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}

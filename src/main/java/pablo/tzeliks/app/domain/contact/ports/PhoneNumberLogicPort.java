package pablo.tzeliks.app.domain.contact.ports;

public interface PhoneNumberLogicPort {

    String minimize(String phoneNumber);

    boolean validate(String phoneNumber);

    String maximize(String phoneNumber);
}

package pablo.tzeliks.app.domain.user.ports;

public interface PasswordEncoderPort {

    String encode(String rawPassword);
    String decode(String hashPassword);
}

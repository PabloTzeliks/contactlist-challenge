package pablo.tzeliks.app.domain.user.ports;

import pablo.tzeliks.app.domain.user.model.User;

public interface TokenLogicPort {

    String generate(User user);
    String validate(String token);
}

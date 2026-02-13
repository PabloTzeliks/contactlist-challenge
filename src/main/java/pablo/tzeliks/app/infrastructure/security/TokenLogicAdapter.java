package pablo.tzeliks.app.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pablo.tzeliks.app.domain.user.model.User;
import pablo.tzeliks.app.domain.user.ports.TokenLogicPort;
import pablo.tzeliks.app.infrastructure.exception.InfrastructureException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenLogicAdapter implements TokenLogicPort {

    @Value(value = "api.security.token.secret")
    private String secret;

    public String generate(User user) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("contact-api")
                    .withSubject(user.getUsername())
                    .withClaim("id", user.getId().toString())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new InfrastructureException("Erro ao gerar Token" + exception);
        }
    }

    public String validate(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("contact-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}

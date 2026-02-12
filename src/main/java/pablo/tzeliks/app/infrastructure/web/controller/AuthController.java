package pablo.tzeliks.app.infrastructure.web.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pablo.tzeliks.app.application.user.dto.auth.LoginRequest;
import pablo.tzeliks.app.application.user.dto.auth.LoginResponse;
import pablo.tzeliks.app.application.user.dto.auth.RegisterRequest;
import pablo.tzeliks.app.application.user.usecase.CreateUserUseCase;
import pablo.tzeliks.app.application.user.usecase.LoginUseCase;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CreateUserUseCase createUserUseCase;
    private final LoginUseCase loginUseCase;

    public AuthController(CreateUserUseCase createUserUseCase, LoginUseCase loginUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {

        return ResponseEntity.ok().body(loginUseCase.execute(request));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequest request) {

        createUserUseCase.execute(request);

        return ResponseEntity.ok().build();
    }
}

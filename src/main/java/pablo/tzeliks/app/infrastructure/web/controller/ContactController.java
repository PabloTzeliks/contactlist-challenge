package pablo.tzeliks.app.infrastructure.web.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pablo.tzeliks.app.application.contact.dto.ContactResponse;
import pablo.tzeliks.app.application.contact.dto.CreateContactRequest;
import pablo.tzeliks.app.application.contact.usecase.AddContactUseCase;
import pablo.tzeliks.app.domain.user.model.User;
import pablo.tzeliks.app.infrastructure.security.CustomUserDetails;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private AddContactUseCase addContact;

    public ContactController(AddContactUseCase addContact) {
        this.addContact = addContact;
    }

    @PostMapping
    public ResponseEntity<ContactResponse> add(@Valid @RequestBody CreateContactRequest request,
                                               @AuthenticationPrincipal CustomUserDetails userDetails,
                                               UriComponentsBuilder uriBuilder) {

        ContactResponse response = addContact.execute(request, userDetails.getDomainUser().getId());

        var uri = uriBuilder.path("/contacts/{id}").buildAndExpand(response.id()).toUri();

        return ResponseEntity.created(uri).body(response);
    }
}

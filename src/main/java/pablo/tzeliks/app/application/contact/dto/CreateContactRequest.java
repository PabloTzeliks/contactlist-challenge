package pablo.tzeliks.app.application.contact.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record CreateContactRequest(

        @JsonProperty("name")
        @NotNull
        String name,

        @JsonProperty("phone_number")
        @NotNull
        String phoneNumber
) { }

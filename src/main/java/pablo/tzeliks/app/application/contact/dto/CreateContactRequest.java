package pablo.tzeliks.app.application.contact.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record CreateContactRequest(

        @JsonProperty("name")
        @NotNull(message = "Nome é obrigatório")
        String name,

        @JsonProperty("phone_number")
        @NotNull(message = "Número de Telefone é obrigatório")
        String phoneNumber
) { }

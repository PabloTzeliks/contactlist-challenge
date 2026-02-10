package pablo.tzeliks.app.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

public record ContactResponse(

        @JsonProperty("id")
        @NotNull
        UUID id,

        @JsonProperty("name")
        @NotNull
        String name,

        @JsonProperty("phone_number")
        @NotNull
        @Length(max = 13, min = 13)
        String phoneNumber,

        @JsonProperty("created_at")
        @NotNull
        LocalDateTime createdAt
) { }

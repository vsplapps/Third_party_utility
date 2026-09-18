package com.evisa.thirdparty.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WatchlistCheckRequest {

    @NotBlank(message = "passengerName is required")
    @Schema(description = "Full name of the passenger", example = "John Doe")
    private String passengerName;

    @NotBlank(message = "passportNumber is required")
    @Schema(description = "Passport number of the passenger", example = "P1234567")
    private String passportNumber;

    @NotBlank(message = "nationality is required")
    @Schema(description = "Nationality of the passenger", example = "Indian")
    private String nationality;
}

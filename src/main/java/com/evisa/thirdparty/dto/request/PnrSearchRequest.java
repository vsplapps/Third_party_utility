package com.evisa.thirdparty.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PnrSearchRequest {

    @NotBlank(message = "pnrNumber is required")
    @Schema(description = "Flight PNR (booking reference) number", example = "PNR123456")
    private String pnrNumber;
}

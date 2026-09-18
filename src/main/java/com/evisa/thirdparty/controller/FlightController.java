package com.evisa.thirdparty.controller;

import com.evisa.thirdparty.dto.request.PnrSearchRequest;
import com.evisa.thirdparty.dto.response.ApiResponse;
import com.evisa.thirdparty.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/third-party/flight")
@RequiredArgsConstructor
@Tag(name = "Flight", description = "Flight PNR lookup APIs")
public class FlightController {

    private final FlightService flightService;

    @PostMapping("/search-pnr")
    @Operation(summary = "Search flight ticket details by PNR number")
    public ResponseEntity<ApiResponse> searchByPnr(@Valid @RequestBody PnrSearchRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(flightService.searchByPnr(request)));
    }
}

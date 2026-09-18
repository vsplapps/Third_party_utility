package com.evisa.thirdparty.controller;

import com.evisa.thirdparty.dto.request.WatchlistCheckRequest;
import com.evisa.thirdparty.dto.response.ApiResponse;
import com.evisa.thirdparty.service.WatchlistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/third-party/watchlist")
@RequiredArgsConstructor
@Tag(name = "Watchlist", description = "Passenger watchlist screening APIs")
public class WatchlistController {

    private final WatchlistService watchlistService;

    @PostMapping("/check")
    @Operation(summary = "Check whether a passenger is on the watchlist (returns true/false)")
    public ResponseEntity<ApiResponse> check(@Valid @RequestBody WatchlistCheckRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(watchlistService.check(request)));
    }
}

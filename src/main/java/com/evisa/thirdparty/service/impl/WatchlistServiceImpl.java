package com.evisa.thirdparty.service.impl;

import com.evisa.thirdparty.dto.request.WatchlistCheckRequest;
import com.evisa.thirdparty.dto.response.WatchlistCheckResponse;
import com.evisa.thirdparty.repository.WatchlistEntryRepository;
import com.evisa.thirdparty.service.WatchlistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class WatchlistServiceImpl implements WatchlistService {

    private final WatchlistEntryRepository watchlistEntryRepository;

    @Override
    @Transactional(readOnly = true)
    public WatchlistCheckResponse check(WatchlistCheckRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request body cannot be null");
        }
        String name = safeTrim(request.getPassengerName());
        String passport = safeTrim(request.getPassportNumber());
        String nationality = safeTrim(request.getNationality());

        if (passport.isEmpty() && (name.isEmpty() || nationality.isEmpty())) {
            throw new IllegalArgumentException("Provide passportNumber, or both passengerName and nationality");
        }

        // Match by passport number OR by name + nationality among active entries.
        boolean watchlisted =
                (!passport.isEmpty()
                        && watchlistEntryRepository.existsByActiveTrueAndPassportNumberIgnoreCase(passport))
                || (!name.isEmpty() && !nationality.isEmpty()
                        && watchlistEntryRepository
                                .existsByActiveTrueAndPassengerNameIgnoreCaseAndNationalityIgnoreCase(name, nationality));

        log.info("Watchlist check: name={}, passport={}, nationality={} -> watchlisted={}",
                name, passport, nationality, watchlisted);

        return WatchlistCheckResponse.builder()
                .watchlisted(watchlisted)
                .passengerName(request.getPassengerName())
                .passportNumber(request.getPassportNumber())
                .nationality(request.getNationality())
                .build();
    }

    private String safeTrim(String value) {
        return value == null ? "" : value.trim();
    }
}

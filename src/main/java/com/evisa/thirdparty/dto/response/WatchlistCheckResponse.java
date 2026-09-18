package com.evisa.thirdparty.dto.response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WatchlistCheckResponse {

    /**
     * true  = passenger is on the watchlist (a match was found)
     * false = passenger is clear (no match)
     */
    private boolean watchlisted;

    private String passengerName;
    private String passportNumber;
    private String nationality;
}

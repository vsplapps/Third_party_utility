package com.evisa.thirdparty.service;

import com.evisa.thirdparty.dto.request.PnrSearchRequest;
import com.evisa.thirdparty.dto.response.TicketDetailsResponse;

public interface FlightService {

    TicketDetailsResponse searchByPnr(PnrSearchRequest request);
}

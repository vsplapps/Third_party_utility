package com.evisa.thirdparty.service.impl;

import com.evisa.thirdparty.dto.request.PnrSearchRequest;
import com.evisa.thirdparty.dto.response.TicketDetailsResponse;
import com.evisa.thirdparty.entity.FlightTicket;
import com.evisa.thirdparty.exception.ResourceNotFoundException;
import com.evisa.thirdparty.repository.FlightTicketRepository;
import com.evisa.thirdparty.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightTicketRepository flightTicketRepository;

    @Override
    @Transactional(readOnly = true)
    public TicketDetailsResponse searchByPnr(PnrSearchRequest request) {
        if (request == null || request.getPnrNumber() == null || request.getPnrNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("pnrNumber is required");
        }

        String pnr = request.getPnrNumber().trim();
        log.info("Searching flight ticket by PNR={}", pnr);

        FlightTicket ticket = flightTicketRepository.findByPnrNumberIgnoreCase(pnr)
                .orElseThrow(() -> new ResourceNotFoundException("No ticket found for PNR: " + pnr));

        return TicketDetailsResponse.builder()
                .pnrNumber(ticket.getPnrNumber())
                .passengerName(ticket.getPassengerName())
                .airline(ticket.getAirline())
                .flightNumber(ticket.getFlightNumber())
                .origin(ticket.getOrigin())
                .originCountry(ticket.getOriginCountry())
                .destination(ticket.getDestination())
                .destinationCountry(ticket.getDestinationCountry())
                .departureTime(ticket.getDepartureTime())
                .arrivalTime(ticket.getArrivalTime())
                .seatNumber(ticket.getSeatNumber())
                .travelClass(ticket.getTravelClass())
                .bookingStatus(ticket.getBookingStatus())
                .build();
    }
}

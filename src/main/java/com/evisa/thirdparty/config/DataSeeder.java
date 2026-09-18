package com.evisa.thirdparty.config;

import com.evisa.thirdparty.entity.FlightTicket;
import com.evisa.thirdparty.entity.WatchlistEntry;
import com.evisa.thirdparty.repository.FlightTicketRepository;
import com.evisa.thirdparty.repository.WatchlistEntryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Seeds dummy data so the two search APIs return meaningful results out of the box.
 * Runs only when the respective tables are empty.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final FlightTicketRepository flightTicketRepository;
    private final WatchlistEntryRepository watchlistEntryRepository;

    @Override
    public void run(String... args) {
        seedFlightTickets();
        seedWatchlist();
    }

    private void seedFlightTickets() {
        if (flightTicketRepository.count() > 0) {
            return;
        }
        List<FlightTicket> tickets = List.of(
                FlightTicket.builder()
                        .pnrNumber("PNR123456")
                        .passengerName("John Doe")
                        .airline("Air India")
                        .flightNumber("AI-202")
                        .origin("DEL")
                        .originCountry("India")
                        .destination("JFK")
                        .destinationCountry("United States")
                        .departureTime(LocalDateTime.now().plusDays(3).withHour(9).withMinute(30))
                        .arrivalTime(LocalDateTime.now().plusDays(3).withHour(20).withMinute(15))
                        .seatNumber("14A")
                        .travelClass("ECONOMY")
                        .bookingStatus("CONFIRMED")
                        .build(),
                FlightTicket.builder()
                        .pnrNumber("PNR789012")
                        .passengerName("Jane Smith")
                        .airline("Emirates")
                        .flightNumber("EK-517")
                        .origin("BOM")
                        .originCountry("India")
                        .destination("LHR")
                        .destinationCountry("United Kingdom")
                        .departureTime(LocalDateTime.now().plusDays(5).withHour(2).withMinute(45))
                        .arrivalTime(LocalDateTime.now().plusDays(5).withHour(8).withMinute(10))
                        .seatNumber("2C")
                        .travelClass("BUSINESS")
                        .bookingStatus("CONFIRMED")
                        .build()
        );
        flightTicketRepository.saveAll(tickets);
        log.info("Seeded {} dummy flight tickets", tickets.size());
    }

    private void seedWatchlist() {
        if (watchlistEntryRepository.count() > 0) {
            return;
        }
        List<WatchlistEntry> entries = List.of(
                WatchlistEntry.builder()
                        .passengerName("Bad Actor")
                        .passportNumber("X9999999")
                        .nationality("Unknown")
                        .reason("Interpol red notice (dummy)")
                        .active(true)
                        .build(),
                WatchlistEntry.builder()
                        .passengerName("Suspicious Person")
                        .passportNumber("Z1112223")
                        .nationality("Indian")
                        .reason("Overstay history (dummy)")
                        .active(true)
                        .build()
        );
        watchlistEntryRepository.saveAll(entries);
        log.info("Seeded {} dummy watchlist entries", entries.size());
    }
}

package com.evisa.thirdparty.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "flight_ticket")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pnr_number", length = 20, unique = true, nullable = false)
    private String pnrNumber;

    @Column(name = "passenger_name", length = 150)
    private String passengerName;

    @Column(name = "airline", length = 100)
    private String airline;

    @Column(name = "flight_number", length = 20)
    private String flightNumber;

    @Column(name = "origin", length = 100)
    private String origin;

    @Column(name = "origin_country", length = 100)
    private String originCountry;

    @Column(name = "destination", length = 100)
    private String destination;

    @Column(name = "destination_country", length = 100)
    private String destinationCountry;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name = "seat_number", length = 10)
    private String seatNumber;

    @Column(name = "travel_class", length = 30)
    private String travelClass;

    @Column(name = "booking_status", length = 30)
    private String bookingStatus;
}

package com.evisa.thirdparty.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "watchlist_entry")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WatchlistEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "passenger_name", length = 150)
    private String passengerName;

    @Column(name = "passport_number", length = 50)
    private String passportNumber;

    @Column(name = "nationality", length = 100)
    private String nationality;

    @Column(name = "reason", length = 255)
    private String reason;

    @Column(name = "active")
    @Builder.Default
    private Boolean active = true;
}

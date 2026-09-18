package com.evisa.thirdparty.repository;

import com.evisa.thirdparty.entity.FlightTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightTicketRepository extends JpaRepository<FlightTicket, Long> {

    Optional<FlightTicket> findByPnrNumberIgnoreCase(String pnrNumber);

    boolean existsByPnrNumberIgnoreCase(String pnrNumber);
}

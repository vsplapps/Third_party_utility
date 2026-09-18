package com.evisa.thirdparty.repository;

import com.evisa.thirdparty.entity.WatchlistEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchlistEntryRepository extends JpaRepository<WatchlistEntry, Long> {

    /**
     * A person is considered "on the watchlist" when an active entry matches
     * the passport number (primary key for a person) OR the name + nationality.
     */
    boolean existsByActiveTrueAndPassportNumberIgnoreCase(String passportNumber);

    boolean existsByActiveTrueAndPassengerNameIgnoreCaseAndNationalityIgnoreCase(String passengerName, String nationality);
}

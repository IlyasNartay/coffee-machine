package iliyasnartay.coffeemachine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import iliyasnartay.coffeemachine.models.HolidayCache;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface HolidayCacheRepository extends JpaRepository<HolidayCache, Long> {
    // Find a holiday by date and country code
    Optional<HolidayCache> findByDateAndCountryCode(LocalDate date, String countryCode);
}

package iliyasnartay.coffeemachine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import iliyasnartay.coffeemachine.models.Statistics;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    // Find statistics for a specific coffee on a specific date
    Optional<Statistics> findByCoffeeIdAndDate(Long coffeeId, LocalDate date);
}

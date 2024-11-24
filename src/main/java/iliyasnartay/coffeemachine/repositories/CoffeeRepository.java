package iliyasnartay.coffeemachine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import iliyasnartay.coffeemachine.models.Coffee;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    // Custom query to find the most popular drink
    Coffee findTopByOrderByPopularityDesc();
}
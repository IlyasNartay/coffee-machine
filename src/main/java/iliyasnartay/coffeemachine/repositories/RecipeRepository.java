package iliyasnartay.coffeemachine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import iliyasnartay.coffeemachine.models.Recipe;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    // Find all recipes by coffee ID
    List<Recipe> findByCoffeeId(Long coffeeId);
}

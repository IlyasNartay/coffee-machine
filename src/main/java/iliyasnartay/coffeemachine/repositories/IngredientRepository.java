package iliyasnartay.coffeemachine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import iliyasnartay.coffeemachine.models.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    // Find an ingredient by name
    Ingredient findByName(String name);
}

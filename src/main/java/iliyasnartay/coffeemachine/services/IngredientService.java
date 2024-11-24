package iliyasnartay.coffeemachine.services;

import iliyasnartay.coffeemachine.dto.IngredientDTO;
import iliyasnartay.coffeemachine.models.Ingredient;
import iliyasnartay.coffeemachine.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    // Fetch all ingredients
    public List<IngredientDTO> getAllIngredients() {
        return ingredientRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Add or update an ingredient
    public IngredientDTO saveIngredient(IngredientDTO ingredientDTO) {
        Ingredient ingredient = mapToEntity(ingredientDTO);
        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        return mapToDTO(savedIngredient);
    }

    // Mapping methods
    private IngredientDTO mapToDTO(Ingredient ingredient) {
        return new IngredientDTO.Builder()
                .setId(ingredient.getId())
                .setName(ingredient.getName())
                .setQuantity(ingredient.getQuantity())
                .build();
    }

    private Ingredient mapToEntity(IngredientDTO ingredientDTO) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientDTO.getId());
        ingredient.setName(ingredientDTO.getName());
        ingredient.setQuantity(ingredientDTO.getQuantity());
        return ingredient;
    }
}

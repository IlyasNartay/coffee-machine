package iliyasnartay.coffeemachine.services;

import iliyasnartay.coffeemachine.dto.RecipeDTO;
import iliyasnartay.coffeemachine.models.Recipe;
import iliyasnartay.coffeemachine.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    // Fetch all recipes for a coffee
    public List<RecipeDTO> getRecipesByCoffeeId(Long coffeeId) {
        return recipeRepository.findByCoffeeId(coffeeId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Add a recipe
    public RecipeDTO addRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = mapToEntity(recipeDTO);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return mapToDTO(savedRecipe);
    }

    // Mapping methods
    private RecipeDTO mapToDTO(Recipe recipe) {
        return new RecipeDTO.Builder()
                .setId(recipe.getId())
                .setCoffeeId(recipe.getCoffee().getId())
                .setIngredientId(recipe.getIngredient().getId())
                .setQuantity(recipe.getQuantity())
                .build();
    }

    private Recipe mapToEntity(RecipeDTO recipeDTO) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDTO.getId());
        recipe.setQuantity(recipeDTO.getQuantity());
        return recipe;
    }
}

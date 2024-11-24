package iliyasnartay.coffeemachine.controllers;

import iliyasnartay.coffeemachine.dto.RecipeDTO;
import iliyasnartay.coffeemachine.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    // Fetch all recipes for a coffee
    @GetMapping("/coffee/{coffeeId}")
    public ResponseEntity<List<RecipeDTO>> getRecipesByCoffeeId(@PathVariable Long coffeeId) {
        return ResponseEntity.ok(recipeService.getRecipesByCoffeeId(coffeeId));
    }

    // Add a new recipe
    @PostMapping
    public ResponseEntity<RecipeDTO> addRecipe(@RequestBody RecipeDTO recipeDTO) {
        return ResponseEntity.ok(recipeService.addRecipe(recipeDTO));
    }
}

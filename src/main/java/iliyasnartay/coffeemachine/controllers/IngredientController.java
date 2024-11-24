package iliyasnartay.coffeemachine.controllers;

import iliyasnartay.coffeemachine.dto.IngredientDTO;
import iliyasnartay.coffeemachine.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    // Fetch all ingredients
    @GetMapping
    public ResponseEntity<List<IngredientDTO>> getAllIngredients() {
        return ResponseEntity.ok(ingredientService.getAllIngredients());
    }

    // Add or update an ingredient
    @PostMapping
    public ResponseEntity<IngredientDTO> saveIngredient(@RequestBody IngredientDTO ingredientDTO) {
        return ResponseEntity.ok(ingredientService.saveIngredient(ingredientDTO));
    }
}

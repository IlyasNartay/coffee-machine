package iliyasnartay.coffeemachine.controllers;

import iliyasnartay.coffeemachine.dto.CoffeeDTO;
import iliyasnartay.coffeemachine.services.CoffeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffees")
public class CoffeeController {
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    // Fetch all coffees
    @GetMapping
    public ResponseEntity<List<CoffeeDTO>> getAllCoffees() {
        return ResponseEntity.ok(coffeeService.getAllCoffees());
    }

    // Fetch the most popular coffee
    @GetMapping("/most-popular")
    public ResponseEntity<CoffeeDTO> getMostPopularCoffee() {
        CoffeeDTO coffeeDTO = coffeeService.getMostPopularCoffee();
        return coffeeDTO != null ? ResponseEntity.ok(coffeeDTO) : ResponseEntity.notFound().build();
    }

    // Add a new coffee
    @PostMapping
    public ResponseEntity<CoffeeDTO> addCoffee(@RequestBody CoffeeDTO coffeeDTO) {
        return ResponseEntity.ok(coffeeService.addCoffee(coffeeDTO));
    }
}

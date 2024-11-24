package iliyasnartay.coffeemachine.services;

import iliyasnartay.coffeemachine.dto.CoffeeDTO;
import iliyasnartay.coffeemachine.models.Coffee;
import iliyasnartay.coffeemachine.repositories.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    // Fetch all coffees
    public List<CoffeeDTO> getAllCoffees() {
        return coffeeRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Get the most popular coffee
    public CoffeeDTO getMostPopularCoffee() {
        Coffee coffee = coffeeRepository.findTopByOrderByPopularityDesc();
        return coffee != null ? mapToDTO(coffee) : null;
    }

    // Add a new coffee
    public CoffeeDTO addCoffee(CoffeeDTO coffeeDTO) {
        Coffee coffee = mapToEntity(coffeeDTO);
        Coffee savedCoffee = coffeeRepository.save(coffee);
        return mapToDTO(savedCoffee);
    }

    // Mapping methods
    private CoffeeDTO mapToDTO(Coffee coffee) {
        return new CoffeeDTO.Builder()
                .setId(coffee.getId())
                .setName(coffee.getName())
                .setWater(coffee.getWater())
                .setMilk(coffee.getMilk())
                .setCoffeeBeans(coffee.getCoffeeBeans())
                .setPopularity(coffee.getPopularity())
                .build();
    }

    private Coffee mapToEntity(CoffeeDTO coffeeDTO) {
        Coffee coffee = new Coffee();
        coffee.setId(coffeeDTO.getId());
        coffee.setName(coffeeDTO.getName());
        coffee.setWater(coffeeDTO.getWater());
        coffee.setMilk(coffeeDTO.getMilk());
        coffee.setCoffeeBeans(coffeeDTO.getCoffeeBeans());
        coffee.setPopularity(coffeeDTO.getPopularity());
        return coffee;
    }
}

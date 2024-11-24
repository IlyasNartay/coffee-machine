package iliyasnartay.coffeemachine.models;

import jakarta.persistence.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coffee_id", nullable = false)
    private Coffee coffee;

    @ManyToOne
    @JoinColumn(name = "ingredient_id", nullable = false)
    private Ingredient ingredient;

    private int quantity; // Quantity of ingredient used in the recipe

    public Long getId() {
        return id;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

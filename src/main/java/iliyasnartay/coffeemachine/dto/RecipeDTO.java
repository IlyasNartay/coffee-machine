package iliyasnartay.coffeemachine.dto;

public class RecipeDTO {
    private Long id;
    private Long coffeeId;
    private Long ingredientId;
    private int quantity;

    private RecipeDTO(Builder builder) {
        this.id = builder.id;
        this.coffeeId = builder.coffeeId;
        this.ingredientId = builder.ingredientId;
        this.quantity = builder.quantity;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getCoffeeId() {
        return coffeeId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public int getQuantity() {
        return quantity;
    }

    // Builder class
    public static class Builder {
        private Long id;
        private Long coffeeId;
        private Long ingredientId;
        private int quantity;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setCoffeeId(Long coffeeId) {
            this.coffeeId = coffeeId;
            return this;
        }

        public Builder setIngredientId(Long ingredientId) {
            this.ingredientId = ingredientId;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public RecipeDTO build() {
            return new RecipeDTO(this);
        }
    }
}

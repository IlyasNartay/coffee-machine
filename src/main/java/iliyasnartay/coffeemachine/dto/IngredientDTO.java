package iliyasnartay.coffeemachine.dto;

public class IngredientDTO {
    private Long id;
    private String name;
    private int quantity;

    private IngredientDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.quantity = builder.quantity;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    // Builder class
    public static class Builder {
        private Long id;
        private String name;
        private int quantity;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public IngredientDTO build() {
            return new IngredientDTO(this);
        }
    }
}

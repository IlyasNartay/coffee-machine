package iliyasnartay.coffeemachine.dto;

public class CoffeeDTO {
    private Long id;
    private String name;
    private int water;
    private int milk;
    private int coffeeBeans;
    private int popularity;

    // Private constructor
    private CoffeeDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.water = builder.water;
        this.milk = builder.milk;
        this.coffeeBeans = builder.coffeeBeans;
        this.popularity = builder.popularity;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getPopularity() {
        return popularity;
    }

    // Builder class
    public static class Builder {
        private Long id;
        private String name;
        private int water;
        private int milk;
        private int coffeeBeans;
        private int popularity;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setWater(int water) {
            this.water = water;
            return this;
        }

        public Builder setMilk(int milk) {
            this.milk = milk;
            return this;
        }

        public Builder setCoffeeBeans(int coffeeBeans) {
            this.coffeeBeans = coffeeBeans;
            return this;
        }

        public Builder setPopularity(int popularity) {
            this.popularity = popularity;
            return this;
        }

        public CoffeeDTO build() {
            return new CoffeeDTO(this);
        }
    }
}

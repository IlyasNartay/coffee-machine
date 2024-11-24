package iliyasnartay.coffeemachine.dto;

import java.time.LocalDate;

public class StatisticsDTO {
    private Long id;
    private Long coffeeId;
    private LocalDate date;
    private int count;

    private StatisticsDTO(Builder builder) {
        this.id = builder.id;
        this.coffeeId = builder.coffeeId;
        this.date = builder.date;
        this.count = builder.count;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Long getCoffeeId() {
        return coffeeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCount() {
        return count;
    }

    // Builder class
    public static class Builder {
        private Long id;
        private Long coffeeId;
        private LocalDate date;
        private int count;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setCoffeeId(Long coffeeId) {
            this.coffeeId = coffeeId;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setCount(int count) {
            this.count = count;
            return this;
        }

        public StatisticsDTO build() {
            return new StatisticsDTO(this);
        }
    }
}

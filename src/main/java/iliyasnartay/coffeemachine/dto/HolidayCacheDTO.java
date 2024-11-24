package iliyasnartay.coffeemachine.dto;

import java.time.LocalDate;

public class HolidayCacheDTO {
    private Long id;
    private LocalDate date;
    private String countryCode;
    private String description;

    private HolidayCacheDTO(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.countryCode = builder.countryCode;
        this.description = builder.description;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDescription() {
        return description;
    }

    // Builder class
    public static class Builder {
        private Long id;
        private LocalDate date;
        private String countryCode;
        private String description;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public HolidayCacheDTO build() {
            return new HolidayCacheDTO(this);
        }
    }
}

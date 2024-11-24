package iliyasnartay.coffeemachine.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class HolidayCache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String countryCode; // e.g., "KZ", "US"
    private String description; // Description of the holiday

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

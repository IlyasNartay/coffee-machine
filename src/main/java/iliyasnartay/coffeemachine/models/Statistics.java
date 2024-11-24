package iliyasnartay.coffeemachine.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coffee_id", nullable = false)
    private Coffee coffee;

    private LocalDate date;
    private int count; // Number of orders for this coffee on a specific date

    public Long getId() {
        return id;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getCount() {
        return count;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

package iliyasnartay.coffeemachine.models;

import jakarta.persistence.*;

@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int water; // мл воды
    private int milk; // мл молока
    private int coffeeBeans; // грамм кофе
    private int popularity; // для статистики

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }
}

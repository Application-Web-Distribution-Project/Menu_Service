package com.esprit.microservice.menu;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Menu {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;  // Change from int to Long

    private String name;
    private String description;
    private BigDecimal price;

    public Menu() {
    }

    public Menu(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {  // Updated return type to Long
        return id;
    }

    public void setId(Long id) {  // Updated parameter type to Long
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

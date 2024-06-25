package com.project.demo.logic.entity.product;

import com.project.demo.logic.entity.category.Category;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Table(name = "products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true, length = 200)
    private String name;
    @Column (length = 500)
    private String description;
    @Column (nullable = false)
    private double price;
    @Column (nullable = false)
    private int stock;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    /**
     * El Many to One establece una relación de muchos
     * a uno entre la tabla de productos y la tabla de
     * categorías.
     *
     * El JoinColumn se utiliza para especificar la columna
     * de la tabla de productos que se utilizará para
     * la relación.
     */
    public Product(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

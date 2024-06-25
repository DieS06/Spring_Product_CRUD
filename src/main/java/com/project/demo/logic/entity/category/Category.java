package com.project.demo.logic.entity.category;

import com.project.demo.logic.entity.product.Product;
import jakarta.persistence.*;

import java.util.ArrayList;

@Table(name = "category")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true, length = 500)
    private String name;
    @Column (length = 500)
    private String description;

    /**
     * El One to Many establece una relación de uno
     * a muchos entre la tabla de categorías y la tabla
     * de productos.
     *
     * El mappedBy se utiliza para especificar la columna
     * de la tabla de productos que se utilizará para la
     * relación.
     */
    public Category (){}

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

}

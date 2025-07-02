package com.Kostyl.financial.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "categories")
public class Categories implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public Categories() {}

    public Categories(String name, boolean isCustom) {
        this.name = name;

    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categories)) return false;
        Categories category = (Categories) o;
        return Objects.equals(getName(), category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
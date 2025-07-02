package com.Kostyl.financial.model.dtos;

import com.Kostyl.financial.model.Categories;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.Objects;

public class FinancialCardDTO {
    private long id;
    private String description;
    private Long price;
    private Date creationDate;
    private boolean isPaid;
    private CategoriesDTO category;

    // Getters e setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public CategoriesDTO getCategory() {
        return category;
    }

    public void setCategory(CategoriesDTO category) {
        this.category = category;
    }
}
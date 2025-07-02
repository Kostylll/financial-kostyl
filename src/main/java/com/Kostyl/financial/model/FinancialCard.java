package com.Kostyl.financial.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "financialcard")
public class FinancialCard implements Serializable {

    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String description;

    private Long price;

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "is_paid")
    private boolean isPaid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Categories category;

    public Categories getCategory() { return category; }
    public void setCategory(Categories category) { this.category = category; }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        FinancialCard.serialVersionUID = serialVersionUID;
    }

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

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinancialCard that = (FinancialCard) o;
        return getId() == that.getId() && isPaid() == that.isPaid() && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getPrice(), that.getPrice()) && Objects.equals(getCreationDate(), that.getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription(), getPrice(), getCreationDate(), isPaid());
    }
}

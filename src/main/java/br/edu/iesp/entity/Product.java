package br.edu.iesp.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Product extends PanacheEntity {

    private String name;
    private double price;
    private LocalDate manufactureDate;
    private LocalDate expirationDate;

    @ManyToOne
    private ProductType productType;
}

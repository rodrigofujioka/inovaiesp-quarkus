package br.edu.iesp.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class ProductType extends PanacheEntity {

    @Enumerated(EnumType.STRING)
    public ProductTypeEnum typeName;

    @OneToMany(mappedBy = "productType")
    public List<Product> products;
}

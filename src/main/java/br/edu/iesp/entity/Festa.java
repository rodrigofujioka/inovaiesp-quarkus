package br.edu.iesp.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Festa extends PanacheEntity {
    private String nome;
    private String descricao;
}

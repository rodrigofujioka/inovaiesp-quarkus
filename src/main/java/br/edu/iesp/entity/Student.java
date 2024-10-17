package br.edu.iesp.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data  // Lombok gera automaticamente os getters, setters, toString, equals, e hashCode
public class Student extends PanacheEntity {

    private String name;
    private String email;
    private LocalDate birthDate;
}

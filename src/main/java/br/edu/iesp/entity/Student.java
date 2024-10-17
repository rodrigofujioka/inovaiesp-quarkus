package br.edu.iesp.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Student extends PanacheEntity {

    public String name;  // Nome do aluno
    public String email;  // E-mail do aluno
    public LocalDate birthDate;  // Data de nascimento do aluno
}

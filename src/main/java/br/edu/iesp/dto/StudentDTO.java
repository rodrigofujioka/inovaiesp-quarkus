package br.edu.iesp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data  // Lombok gera automaticamente os getters, setters, toString, equals, e hashCode
public class StudentDTO {

    @NotBlank(message = "The name must not be empty")
    private String name;

    @Email(message = "The email must be valid")
    @NotBlank(message = "The email must not be empty")
    private String email;

    @NotNull(message = "Birthdate must not be null")
    private LocalDate birthDate;
}

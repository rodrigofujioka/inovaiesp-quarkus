package br.edu.iesp.dto;

import br.edu.iesp.entity.ProductTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data  // Lombok gera automaticamente getters, setters, toString, equals, e hashCode
public class ProductDTO {

    @NotBlank(message = "The name must not be empty")
    private String name;

    @Positive(message = "The price must be greater than zero")
    private double price;

    @NotNull(message = "Manufacture date must not be null")
    private LocalDate manufactureDate;

    private LocalDate expirationDate;

    @NotNull(message = "Product type must not be null")
    private ProductTypeEnum productType;
}

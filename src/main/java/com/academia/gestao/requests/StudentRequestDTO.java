package com.academia.gestao.requests;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
public class StudentRequestDTO {

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters.")
    private String name;

    @Email(message = "Enter a valid email.")
    @NotBlank(message = "Email is required.")
    private String email;

    @NotBlank(message = "CPF is required.")
    @CPF(message = "Enter a valid CPF.")
    private String cpf;

    @NotNull(message = "Birth date is required.")
    @Past(message = "Birth date must be a date in the past.")
    private LocalDate birthDate;
}

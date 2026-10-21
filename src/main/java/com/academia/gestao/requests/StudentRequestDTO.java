package com.academia.gestao.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
public class StudentRequestDTO {

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 80, message = "Name must be between 3 and 80 characters.")
    private String name;

    @Email(message = "Enter a valid email.")
    @NotBlank(message = "Email is required.")
    private String email;

    @NotBlank(message = "CPF is required.")
    @CPF(message = "Enter a valid CPF.")
    private String cpf;

}

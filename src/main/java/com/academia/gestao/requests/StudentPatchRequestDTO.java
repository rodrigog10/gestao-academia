package com.academia.gestao.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
public class StudentPatchRequestDTO {
    @Size(min = 3, max = 80, message = "Name must be between 3 and 80 characters.")
    private String name;

    @Email(message = "Enter a valid email.")
    private String email;

    @CPF(message = "Enter a valid CPF.")
    private String cpf;

    @Past(message = "Birth date must be a date in the past.")
    private LocalDate birthDate;

}

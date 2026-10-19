package com.academia.gestao.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentPatchRequestDTO {
    @Size(min = 3, max = 80, message = "Name must be between 3 and 80 characters.")
    private String name;

    @Email(message = "Enter a valid email.")
    private String email;

    @Size(min = 11, max = 11, message = "Must contain exactly 11 characters.")
    private String cpf;

}

package com.academia.gestao.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlunoPatchRequestDTO {


    @Size(min = 3, max = 80, message = "O nome deve ter entre 3 e 80 caracteres.")
    private String name;

    @Email(message = "Digite um Email válido.")
    private String email;

    @Size(min = 11, max = 11, message = "Deve conter exatamente 11 caracteres.")
    private String cpf;

}

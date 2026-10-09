package com.academia.gestao.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AlunoDTO {

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 3, max = 80, message = "O nome deve ter entre 3 e 80 caracteres.")
    private String name;

    @Email(message = "Digite um Email válido.")
    @NotBlank(message = "O Email é obrigatório.")
    private String email;

    @NotBlank(message = "O CPF é obrigatório.")
    @Size(min = 11, max = 11, message = "Deve conter exatamente 11 caracteres.")
    private String cpf;

}

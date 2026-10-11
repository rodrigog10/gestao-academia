package com.academia.gestao.requests;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AlunoResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String cpf;

}

package com.academia.gestao.responses;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String cpf;

}

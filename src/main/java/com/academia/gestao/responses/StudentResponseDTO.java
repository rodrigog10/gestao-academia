package com.academia.gestao.responses;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
public class StudentResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate birthDate;
    private LocalDateTime createdAt;

}

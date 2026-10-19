package com.academia.gestao.domain;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_aluno")

@Entity // uma classe marcada como entidade representa uma tabela no banco de dados.
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,  length = 80)
    private String name;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false,  length = 11, unique = true)
    private String cpf;
}

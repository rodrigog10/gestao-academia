package com.academia.gestao.mapper;

import com.academia.gestao.domain.Aluno;
import com.academia.gestao.requests.AlunoRequestDTO;
import com.academia.gestao.requests.AlunoResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")

public interface AlunoMapper {
    // dto to entity
    Aluno toAlunoEntity(AlunoRequestDTO alunoPostRequestBody);

    // entity to dto
    AlunoResponseDTO toAlunoDTO(Aluno studentEntity);

    // entities to dto's
    List<AlunoResponseDTO> toAllAlunosDTO(List<Aluno> alunosEntity);
}

package com.academia.gestao.mapper;

import com.academia.gestao.domain.Aluno;
import com.academia.gestao.requests.AlunoRequestDTO;
import com.academia.gestao.requests.AlunoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring")

public interface AlunoMapper {
    // dto to entity
    Aluno toAlunoEntity(AlunoRequestDTO alunoRequestDTO);

    void updateEntityFromDTO(AlunoRequestDTO alunoRequestDTO, @MappingTarget Aluno alunoEntity);

    // entity to dto
    AlunoResponseDTO toAlunoDTO(Aluno studentEntity);

    // entities to dto's
    List<AlunoResponseDTO> toAllAlunosDTO(List<Aluno> alunosEntity);
}

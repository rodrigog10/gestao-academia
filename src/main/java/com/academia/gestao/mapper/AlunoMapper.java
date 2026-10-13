package com.academia.gestao.mapper;

import com.academia.gestao.domain.Aluno;
import com.academia.gestao.requests.AlunoPatchRequestDTO;
import com.academia.gestao.requests.AlunoRequestDTO;
import com.academia.gestao.responses.AlunoResponseDTO;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring")

public interface AlunoMapper {
    // dto to entity
    Aluno toAlunoEntity(AlunoRequestDTO alunoRequestDTO);

    //change all about him
    void updateEntityFromDTO(AlunoRequestDTO alunoRequestDTO, @MappingTarget Aluno alunoEntity);

    //change something about him
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEspecificEntityFromDTO(AlunoPatchRequestDTO alunoPatchRequestDTO, @MappingTarget Aluno alunoEntity);

    // entity to dto
    AlunoResponseDTO toAlunoDTO(Aluno studentEntity);

    // entities to dto's
    List<AlunoResponseDTO> toAllAlunosDTO(List<Aluno> alunosEntity);
}

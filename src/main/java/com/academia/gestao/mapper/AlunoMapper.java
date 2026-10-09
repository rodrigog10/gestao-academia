package com.academia.gestao.mapper;

import com.academia.gestao.domain.Aluno;
import com.academia.gestao.requests.AlunoDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")

public interface AlunoMapper {

    Aluno toAlunoEntity(AlunoDTO alunoPostRequestBody);

}

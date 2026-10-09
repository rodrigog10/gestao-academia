package com.academia.gestao.services;

import com.academia.gestao.domain.Aluno;
import com.academia.gestao.mapper.AlunoMapper;
import com.academia.gestao.repository.AlunoRepository;
import com.academia.gestao.requests.AlunoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Aluno save(AlunoDTO alunoPostRequestBody) {
        return alunoRepository.save(AlunoMapper.INSTANCE.toAlunoEntity(alunoPostRequestBody));
    }

}

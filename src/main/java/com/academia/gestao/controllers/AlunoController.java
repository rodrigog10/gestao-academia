package com.academia.gestao.controllers;

import com.academia.gestao.domain.Aluno;
import com.academia.gestao.requests.AlunoDTO;
import com.academia.gestao.services.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor

@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService alunoService;


    @PostMapping // cadastrar novo aluno
    public ResponseEntity<Aluno> cadastrarAluno(@Valid @RequestBody AlunoDTO alunoPostRequestBody) {
        return new ResponseEntity<>(alunoService.save(alunoPostRequestBody), HttpStatus.CREATED);
    }








    // método para visualizar informação

    // método para editar informação

    // método para deletar



}

package com.academia.gestao.controllers;

import com.academia.gestao.domain.Aluno;
import com.academia.gestao.requests.AlunoRequestDTO;
import com.academia.gestao.requests.AlunoResponseDTO;
import com.academia.gestao.services.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor

@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService alunoService;

    // find one
    @GetMapping(path = "/{id}")
    public ResponseEntity<AlunoResponseDTO> findStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.findStudentById(id));
    }

    // find all
    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> findAllStudents() {
        return ResponseEntity.ok(alunoService.findAllStudents());
    }

    // create student
    @PostMapping
    public ResponseEntity<Aluno> registerStudent(@Valid @RequestBody AlunoRequestDTO alunoPostRequestBody) {
        return new ResponseEntity<>(alunoService.save(alunoPostRequestBody), HttpStatus.CREATED);
    }

    //delete student
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
        alunoService.delete(id);
        // retorna apenas o status http da execução.
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update student

}

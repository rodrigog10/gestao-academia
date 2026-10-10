package com.academia.gestao.services;

import com.academia.gestao.domain.Aluno;
import com.academia.gestao.mapper.AlunoMapper;
import com.academia.gestao.repository.AlunoRepository;
import com.academia.gestao.requests.AlunoRequestDTO;
import com.academia.gestao.requests.AlunoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository studentRepository;
    private final AlunoMapper studentMapper;


    //find one
    public AlunoResponseDTO findStudentById(Long id) {
        Aluno studentEntity = studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aluno não encontrado com Id " + id + "."));

        return studentMapper.toAlunoDTO(studentEntity);
    }

    //find all

    public List<AlunoResponseDTO> findAllStudents() {
        List<Aluno> allStudentsEntitys = studentRepository.findAll();
        return studentMapper.toAllAlunosDTO(allStudentsEntitys);

            // outra forma interessante é utilizar o Java Streams para listagem
        /*
            public List<AlunoResponseDTO> findAllStudents() {
            return studentRepository.findAll()
            .stream()
            .map(alunoEntity -> studentMapper.toAlunoDTO(alunoEntity))
            }
        */
    }

    // create student
    public Aluno save(AlunoRequestDTO alunoPostRequestBody) {
        Aluno student = studentMapper.toAlunoEntity(alunoPostRequestBody);
        return studentRepository.save(student);
    }

    // delete student
    public void delete(Long id) {
        // guard clause
        Aluno studentEntity = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado com id" + id + "."));

        studentRepository.delete(studentEntity);
    }
}

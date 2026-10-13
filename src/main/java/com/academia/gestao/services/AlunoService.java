package com.academia.gestao.services;

import com.academia.gestao.domain.Aluno;
import com.academia.gestao.mapper.AlunoMapper;
import com.academia.gestao.repository.AlunoRepository;
import com.academia.gestao.requests.AlunoPatchRequestDTO;
import com.academia.gestao.requests.AlunoRequestDTO;
import com.academia.gestao.responses.AlunoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;


    //private method to find the entity
    private Aluno findAlunoStudentByid(Long id) {

        return alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado com id" + id + "."));
    }

    //public methods

    // create student
    public AlunoResponseDTO save(AlunoRequestDTO alunoRequestDTO) {

        Aluno alunoEntity = alunoMapper.toAlunoEntity(alunoRequestDTO);
        Aluno alunoSaved = alunoRepository.save(alunoEntity);

        return alunoMapper.toAlunoDTO(alunoSaved);
    }

    // delete student
    public void delete(Long id) {
        // with guard clause
        Aluno alunoEntity = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado com id" + id + "."));
        alunoRepository.delete(alunoEntity);
    }

    //find one
    public AlunoResponseDTO findStudentById(Long id) {
        // with guard clause
        Aluno alunoEntity = alunoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aluno não encontrado com Id " + id + "."));

        return alunoMapper.toAlunoDTO(alunoEntity);
    }

    //find all
    public List<AlunoResponseDTO> findAllStudents() {
        List<Aluno> allStudentsEntitys = alunoRepository.findAll();
        return alunoMapper.toAllAlunosDTO(allStudentsEntitys);

        // outra forma interessante é utilizar o Java Streams para listagem (não só para isso)
        /*
            public List<AlunoResponseDTO> findAllStudents() {
            return alunoRepository.findAll()
            .stream()
            .map(alunoEntity -> alunoMapper.toAlunoDTO(alunoEntity))
            }
        */
    }

    //update student
    public AlunoResponseDTO updateStudent(Long id,  AlunoRequestDTO alunoUpdatedRequestDTO) {

        Aluno alunoEntity = findAlunoStudentByid(id);
         alunoMapper.updateEntityFromDTO( alunoUpdatedRequestDTO , alunoEntity);
        Aluno alunoUpdatedEntity = alunoRepository.save(alunoEntity);

        return alunoMapper.toAlunoDTO(alunoUpdatedEntity);
    }

    public AlunoResponseDTO updateSomethingAboutTheStudent(Long id, AlunoPatchRequestDTO alunoPatchRequestDTO){

        Aluno alunoEntity = findAlunoStudentByid(id);
        alunoMapper.updateEspecificEntityFromDTO(alunoPatchRequestDTO, alunoEntity);
        Aluno alunoUpdatedEntity = alunoRepository.save(alunoEntity);

        return alunoMapper.toAlunoDTO(alunoUpdatedEntity);
    }
}

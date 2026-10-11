package com.academia.gestao.services;

import com.academia.gestao.domain.Aluno;
import com.academia.gestao.mapper.AlunoMapper;
import com.academia.gestao.repository.AlunoRepository;
import com.academia.gestao.requests.AlunoRequestDTO;
import com.academia.gestao.requests.AlunoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    private Aluno findAlunoStudentByid(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado com id" + id + "."));

    }

    // create student
    //inicialmente eu envio o dado e guardo dentro de alunoRequestDTO, envio para o Mapper para transformar em entidade, salvo no banco e devolvo (?)
    public AlunoResponseDTO save(AlunoRequestDTO alunoRequestDTO) {

        Aluno alunoEntity = alunoMapper.toAlunoEntity(alunoRequestDTO);
        Aluno alunoSaved = alunoRepository.save(alunoEntity);
        AlunoResponseDTO alunoDTO = alunoMapper.toAlunoDTO(alunoSaved);
        return alunoDTO;

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
        AlunoResponseDTO alunoFoundedDTO = alunoMapper.toAlunoDTO(alunoEntity);
        return alunoFoundedDTO;

    }

    //find all

    public List<AlunoResponseDTO> findAllStudents() {
        List<Aluno> allStudentsEntitys = alunoRepository.findAll();
        return alunoMapper.toAllAlunosDTO(allStudentsEntitys);

        // outra forma interessante é utilizar o Java Streams para listagem
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
}

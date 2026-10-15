package com.academia.gestao.services;

import com.academia.gestao.domain.Student;
import com.academia.gestao.mapper.StudentMapper;
import com.academia.gestao.repository.StudentRepository;
import com.academia.gestao.requests.StudentPatchRequestDTO;
import com.academia.gestao.requests.StudentRequestDTO;
import com.academia.gestao.responses.StudentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    //private method to find the entity
    private Student findEntityById(Long id) {

        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado com Id " + id + "."));
    }

    //public methods

    // create student
    public StudentResponseDTO create(StudentRequestDTO studentRequestDTO) {

        Student studentEntity = studentMapper.toStudentEntity(studentRequestDTO);
        Student savedStudent = studentRepository.save(studentEntity);

        return studentMapper.toAlunoDTO(savedStudent);
    }

    // delete student
    public void delete(Long id) {
        // with guard clause
        Student studentEntity = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado com Id " + id + "."));
        studentRepository.delete(studentEntity);
    }

    //find one
    public StudentResponseDTO findById(Long id) {
        // with guard clause
        Student studentEntity = studentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Aluno não encontrado com Id " + id + "."));

        return studentMapper.toAlunoDTO(studentEntity);
    }

    //find all
    public List<StudentResponseDTO> findAll() {
        List<Student> allStudentsEntitys = studentRepository.findAll();
        return studentMapper.toAllAlunosDTO(allStudentsEntitys);

        // outra forma interessante é utilizar o Java Streams para listagem (não só para isso)
        /*
            public List<AlunoResponseDTO> findAllStudents() {
            return studentRepository.findAll()
            .stream()
            .map(studentEntity -> studentMapper.toAlunoDTO(studentEntity))
            }
        */
    }

    //update student
    public StudentResponseDTO update(Long id, StudentRequestDTO alunoUpdatedRequestDTO) {

        Student studentEntity = findEntityById(id);
         studentMapper.updateEntityFromDTO( alunoUpdatedRequestDTO , studentEntity);
        Student alunoUpdatedEntity = studentRepository.save(studentEntity);

        return studentMapper.toAlunoDTO(alunoUpdatedEntity);
    }

    public StudentResponseDTO updateSomethingAboutTheStudent(Long id, StudentPatchRequestDTO alunoPatchRequestDTO){

        Student studentEntity = findEntityById(id);
        studentMapper.updateEspecificEntityFromDTO(alunoPatchRequestDTO, studentEntity);
        Student alunoUpdatedEntity = studentRepository.save(studentEntity);

        return studentMapper.toAlunoDTO(alunoUpdatedEntity);
    }
}

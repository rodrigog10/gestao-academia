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


    private Student findEntityById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with Id " + id + "."));
    }

    // public methods

    // create student
    public StudentResponseDTO create(StudentRequestDTO studentRequestDTO) {
        // put a custom exception here: student already exists.
        Student studentEntity = studentMapper.toStudentEntity(studentRequestDTO);
        Student savedStudent = studentRepository.save(studentEntity);

        return studentMapper.toStudentDTO(savedStudent);
    }

    // delete student
    public void delete(Long id) {
        Student studentEntity = findEntityById(id);
        studentRepository.delete(studentEntity);
    }

    // find one
    public StudentResponseDTO findById(Long id) {
        Student studentEntity = findEntityById(id);
        return studentMapper.toStudentDTO(studentEntity);
    }

    // find all
    public List<StudentResponseDTO> findAll() {
        List<Student> allStudentsEntities = studentRepository.findAll();
        return studentMapper.toStudentListDTO(allStudentsEntities);

        /*
            public List<AlunoResponseDTO> findAllStudents() {
            return studentRepository.findAll()
            .stream()
            .map(studentEntity -> studentMapper.toStudentDTO(studentEntity))
            }
        */
    }

    // update student
    public StudentResponseDTO update(Long id, StudentRequestDTO studentRequestDTO) {
        Student studentEntity = findEntityById(id);
        studentMapper.updateEntityFromDTO(studentRequestDTO, studentEntity);
        Student alunoUpdatedEntity = studentRepository.save(studentEntity);

        return studentMapper.toStudentDTO(alunoUpdatedEntity);
    }

    public StudentResponseDTO partialUpdate(Long id, StudentPatchRequestDTO studentPartialRequestDTO) {
        Student studentEntity = findEntityById(id);
        studentMapper.partialEntityUpdateFromDTO(studentPartialRequestDTO, studentEntity);
        Student alunoUpdatedEntity = studentRepository.save(studentEntity);

        return studentMapper.toStudentDTO(alunoUpdatedEntity);
    }
}
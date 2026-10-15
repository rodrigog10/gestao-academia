package com.academia.gestao.mapper;

import com.academia.gestao.domain.Student;
import com.academia.gestao.requests.StudentPatchRequestDTO;
import com.academia.gestao.requests.StudentRequestDTO;
import com.academia.gestao.responses.StudentResponseDTO;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring")

public interface StudentMapper {
    // dto to entity
    Student toStudentEntity(StudentRequestDTO alunoRequestDTO);

    //change all about him
    void updateEntityFromDTO(StudentRequestDTO alunoRequestDTO, @MappingTarget Student alunoEntity);

    //change something about him
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEspecificEntityFromDTO(StudentPatchRequestDTO alunoPatchRequestDTO, @MappingTarget Student alunoEntity);

    // entity to dto
    StudentResponseDTO toAlunoDTO(Student studentEntity);

    // entities to dto's
    List<StudentResponseDTO> toAllAlunosDTO(List<Student> alunosEntity);
}

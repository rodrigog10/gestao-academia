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
    Student toStudentEntity(StudentRequestDTO studentRequestDTO);

    //change all about him
    void updateEntityFromDTO(StudentRequestDTO studentRequestDTO, @MappingTarget Student studentEntity);

    //change something about him
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialEntityUpdateFromDTO(StudentPatchRequestDTO studentPatchRequestDTO, @MappingTarget Student studentEntity);

    // entity to dto
    StudentResponseDTO toStudentDTO(Student studentEntity);

    // entities to dto's
    List<StudentResponseDTO> toStudentListDTO(List<Student> studentsEntities);
}

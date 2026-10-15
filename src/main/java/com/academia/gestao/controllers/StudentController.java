package com.academia.gestao.controllers;

import com.academia.gestao.requests.StudentPatchRequestDTO;
import com.academia.gestao.requests.StudentRequestDTO;
import com.academia.gestao.responses.StudentResponseDTO;
import com.academia.gestao.services.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor

@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    //find one
    @GetMapping(path = "/{id}")
    public ResponseEntity<StudentResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    //find all
    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    //create student
    @PostMapping
    public ResponseEntity<StudentResponseDTO> register(@Valid @RequestBody StudentRequestDTO studentRequestDTO) {
        return new ResponseEntity<>(studentService.create(studentRequestDTO), HttpStatus.CREATED);
    }

    //delete student
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //update student
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> update(@PathVariable Long id, @Valid @RequestBody StudentRequestDTO studentUpdatedRequestDTO) {

        StudentResponseDTO updatedStudent = studentService.update(id, studentUpdatedRequestDTO);
        return ResponseEntity.ok(updatedStudent);

    }

    //update something specific about student
    @PatchMapping(path = "/{id}")
    public ResponseEntity<StudentResponseDTO> partialUpdate(@PathVariable Long id, @Valid @RequestBody StudentPatchRequestDTO studentPatchRequestDTO) {

        StudentResponseDTO updatedStudent = studentService.partialUpdate(id, studentPatchRequestDTO);
        return ResponseEntity.ok(updatedStudent);
    }
}

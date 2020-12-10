package com.study.university.api.rest;


import com.study.university.api.dto.StudentsDto;
import com.study.university.api.dto.UserDto;
import com.study.university.api.model.Student;

import com.study.university.api.service.StudentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/v1/students/")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<StudentsDto> getStudentById(@PathVariable(name = "id") Long id){

        Student student = studentService.findById(id);
        if(student == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        StudentsDto result = StudentsDto.fromStudent(student);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}

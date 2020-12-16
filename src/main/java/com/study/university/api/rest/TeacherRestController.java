package com.study.university.api.rest;


import com.study.university.api.dto.GroupeDto;
import com.study.university.api.dto.TeacherDto;
import com.study.university.api.model.Groupe;
import com.study.university.api.model.Teacher;
import com.study.university.api.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/v1/teacher/")
@Slf4j
public class TeacherRestController {
    private final TeacherService teacherService;

    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<TeacherDto> getStudentById(@PathVariable(name = "id") Long id) {

        Teacher teacher = teacherService.findById(id);
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        TeacherDto result = TeacherDto.fromGroup(teacher);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

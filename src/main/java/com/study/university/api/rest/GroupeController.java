package com.study.university.api.rest;


import com.study.university.api.dto.GroupeDto;
import com.study.university.api.dto.StudentsDto;
import com.study.university.api.model.Groupe;
import com.study.university.api.service.GroupService;
import com.study.university.api.service.StudentService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/v1/groupe/")
@Slf4j
public class GroupeController {

    private final GroupService groupService;
    private final StudentService studentService;

    public GroupeController(GroupService groupService, StudentService studentService) {
        this.groupService = groupService;
        this.studentService = studentService;
    }

    @GetMapping()
    public HashMap<String, Object> getStudentAll(@RequestParam(defaultValue = "1") Integer pageNumber,
                                         @RequestParam(defaultValue = "10") Integer pageSize) {

        HashMap<String, Object> response = new HashMap<>();

        response.put("group", groupService.getAll(pageNumber, pageSize));
        response.put("pageSize", pageSize);
        response.put("pageNumber", pageNumber);
        response.put("countGroup", groupService.countAllGroup());

        return response;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<GroupeDto> getStudentById(@PathVariable(name = "id") Long id) {

        Groupe group = groupService.findById(id);
        if (group == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        GroupeDto result = GroupeDto.fromGroup(group);

        //result.setCountStudent(studentService.findByGroup);

        result.setCountStudent(studentService.findStudentsByGroup(group).size());
        if (group.getStudent() != null) {
            result.setStudentName(group.getStudent().getFirstName() + " " + group.getStudent().getLastName());
        }


        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping("")
    public Groupe createStudent(@RequestBody GroupeDto groupeDto) {

        return groupService.save(groupeDto);
    }
}

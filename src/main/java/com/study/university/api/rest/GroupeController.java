package com.study.university.api.rest;


import com.study.university.api.dto.GroupeDto;
import com.study.university.api.model.Groupe;
import com.study.university.api.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/v1/")
@Slf4j
public class GroupeController {

    private final GroupService groupService;

    public GroupeController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(value = "groupe/{id}")
    public ResponseEntity<GroupeDto> getStudentById(@PathVariable(name = "id") Long id){

        Groupe group = groupService.findById(id);

        if(group == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        GroupeDto result = GroupeDto.fromGroup(group);

        result.setStudentName(group.getStudent().getFirstName() +" "+ group.getStudent().getLastName());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PostMapping("groupe")
    public Groupe createStudent(@RequestBody GroupeDto groupeDto) {

        return groupService.save(groupeDto);
    }
}

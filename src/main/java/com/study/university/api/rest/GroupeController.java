package com.study.university.api.rest;


import com.study.university.api.dto.GroupDto;
import com.study.university.api.model.Groupe;
import com.study.university.api.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/v1/groupe/")
@Slf4j
public class GroupeController {

    private final GroupService groupService;

    public GroupeController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<GroupDto> getStudentById(@PathVariable(name = "id") Long id){

        Groupe group = groupService.findById(id);
        log.info("-----------------------33{}",group);
        if(group == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        GroupDto result = GroupDto.fromGroup(group);
        log.info("-----------------------333344443{}",result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

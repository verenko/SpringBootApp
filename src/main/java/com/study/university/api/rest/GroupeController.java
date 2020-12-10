package com.study.university.api.rest;


import com.study.university.api.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/v1/group/")
@Slf4j
public class GroupeController {

    private final GroupService groupService;

    public GroupeController(GroupService groupService) {
        this.groupService = groupService;
    }
}

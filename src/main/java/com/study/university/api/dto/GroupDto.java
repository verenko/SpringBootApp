package com.study.university.api.dto;

import com.study.university.api.model.Group;
import com.study.university.api.model.Status;
import com.study.university.api.model.Student;

import java.util.Date;

public class GroupDto {
    private Long id;
    private String name;


    public Group toGroup() {
        Group group = new Group();
        group.setId(id);
        group.setName(name);
        return group;
    }

    public static GroupDto fromGroup(Group group) {
        GroupDto groupDto = new GroupDto();
        group.setName(group.getName());
        return groupDto;
    }
}

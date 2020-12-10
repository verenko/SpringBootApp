package com.study.university.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.study.university.api.model.Group;
import lombok.Data;

import java.util.Date;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
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

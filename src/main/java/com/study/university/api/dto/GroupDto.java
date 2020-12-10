package com.study.university.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.study.university.api.model.Groupe;
import com.study.university.api.model.Student;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupDto {
    private Long id;
    private String name;


    public Groupe toGroup() {
        Groupe group = new Groupe();
        group.setId(id);
        group.setName(name);
        return group;
    }

    public static GroupDto fromGroup(Groupe group) {
        GroupDto groupeGto = new GroupDto();
        groupeGto.setId(group.getId());
        groupeGto.setName(group.getName());
        return groupeGto;
    }

}

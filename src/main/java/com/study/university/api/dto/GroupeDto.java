package com.study.university.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.study.university.api.model.Groupe;
import com.study.university.api.model.Student;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupeDto {
    private Long id;
    private String name;
    private Student student;



    public Groupe toGroup() {
        Groupe group = new Groupe();
        group.setId(id);
        group.setName(name);
        group.setStudent(student);
        return group;
    }

    public static GroupeDto fromGroup(Groupe group) {
        GroupeDto groupeGto = new GroupeDto();
        groupeGto.setId(group.getId());
        groupeGto.setName(group.getName());
        groupeGto.setStudent(group.getStudent());
        return groupeGto;
    }

}
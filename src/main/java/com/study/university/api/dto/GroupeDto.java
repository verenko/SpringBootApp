package com.study.university.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.study.university.api.model.Groupe;
import com.study.university.api.model.Student;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupeDto {
    private Long id;
    private String name;
    private String studentName;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int countStudent;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long studentId;


    public Groupe toGroup() {
        Groupe group = new Groupe();
        group.setId(id);
        group.setName(name);
        return group;
    }

    public static GroupeDto fromGroup(Groupe group) {
        GroupeDto groupeDto = new GroupeDto();
        groupeDto.setId(group.getId());
        groupeDto.setName(group.getName());
        return groupeDto;
    }

}

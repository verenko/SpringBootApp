package com.study.university.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.study.university.api.model.Groupe;
import com.study.university.api.model.Student;
import lombok.Data;

import java.util.Date;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentsDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymicName;
    private Date dateBirthDay;
    private Groupe group;

    public Student toStudent(){
        Student student = new Student();
        student.setId(id);
        student.setFistName(firstName);
        student.setLastName(lastName);
        student.setPatronymicName(patronymicName);
        student.setDateBirthDay(dateBirthDay);
        student.setGroup(group);

        return student;
    }

    public static StudentsDto fromStudent(Student student) {
        StudentsDto studentDto = new StudentsDto();

        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFistName());
        studentDto.setLastName(student.getLastName());
        studentDto.setPatronymicName(student.getPatronymicName());
        studentDto.setDateBirthDay(student.getDateBirthDay());
       studentDto.setGroup(student.getGroup());

        return studentDto;
    }
}

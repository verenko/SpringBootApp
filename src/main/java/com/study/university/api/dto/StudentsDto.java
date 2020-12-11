package com.study.university.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.study.university.api.model.Student;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;


@Data
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentsDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymicName;
    private Date dateBirthDay;
    private String group;

    public Student toStudent(){
        Student student = new Student();
        student.setId(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setPatronymicName(patronymicName);
        student.setDateBirthDay(dateBirthDay);

        return student;
    }

    public static StudentsDto fromStudent(Student student) {
        StudentsDto studentDto = new StudentsDto();

        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setPatronymicName(student.getPatronymicName());
        studentDto.setDateBirthDay(student.getDateBirthDay());


        //studentDto.setGroup(student.getGroup());

        return studentDto;
    }
}

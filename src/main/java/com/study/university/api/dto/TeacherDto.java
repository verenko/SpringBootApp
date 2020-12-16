package com.study.university.api.dto;

import com.study.university.api.model.Groupe;
import com.study.university.api.model.Student;
import com.study.university.api.model.Teacher;
import lombok.Data;

import javax.persistence.Column;

@Data
public class TeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymicName;
    private String degree;
    private String email;
    private String phoneNumber;

    public Teacher toTeacher() {
        Teacher teacher = new Teacher();
        teacher.setId(id);
        teacher.setFirstName(firstName);
        teacher.setLastName(lastName);
        teacher.setPatronymicName(patronymicName);
        teacher.setDegree(degree);
        teacher.setEmail(email);
        teacher.setPhoneNumber(phoneNumber);
        return teacher;
    }


    public static TeacherDto fromGroup(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setFirstName(teacher.getFirstName());
        teacherDto.setLastName(teacher.getLastName());
        teacherDto.setPatronymicName(teacher.getPatronymicName());
        teacherDto.setDegree(teacher.getDegree());
        teacherDto.setEmail(teacher.getEmail());
        teacherDto.setPhoneNumber(teacher.getPhoneNumber());

        return teacherDto;
    }










}

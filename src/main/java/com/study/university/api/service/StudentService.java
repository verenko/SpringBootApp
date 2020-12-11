package com.study.university.api.service;

import com.study.university.api.dto.StudentsDto;
import com.study.university.api.model.Student;

import java.util.List;

public interface StudentService {

    //Student register(Student student);

    List<Student> getAll();

    Student findById(Long id);

    Student save(StudentsDto student);




    //void delete(Long id);
}

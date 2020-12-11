package com.study.university.api.service;

import com.study.university.api.model.Student;

import java.util.List;

public interface StudentService {

    //Student register(Student student);

    List<Student> getAll();

    Student findById(Long id);


    //void delete(Long id);
}

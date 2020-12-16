package com.study.university.api.service;

import com.study.university.api.dto.StudentsDto;
import com.study.university.api.model.Groupe;
import com.study.university.api.model.Student;

import java.util.List;

public interface StudentService {

    //Student register(Student student);

    List<StudentsDto> getAll(Integer pageNumber, Integer pageSize);

    Student findById(Long id);

    StudentsDto save(StudentsDto student);


    List<Student> findStudentsByGroup(Groupe groupe);


    //void delete(Long id);
}

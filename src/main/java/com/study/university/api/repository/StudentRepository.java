package com.study.university.api.repository;


import com.study.university.api.model.Groupe;
import com.study.university.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>, PagingAndSortingRepository<Student, Long> {

    List<Student> findStudentsByGroup(Groupe groupe);
}

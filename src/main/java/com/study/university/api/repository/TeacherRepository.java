package com.study.university.api.repository;

import com.study.university.api.model.Student;
import com.study.university.api.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long>, PagingAndSortingRepository<Teacher, Long> {

}

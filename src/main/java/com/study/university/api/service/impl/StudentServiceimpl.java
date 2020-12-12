package com.study.university.api.service.impl;


import com.google.common.collect.Lists;
import com.study.university.api.dto.StudentsDto;
import com.study.university.api.model.Groupe;
import com.study.university.api.model.Student;

import com.study.university.api.repository.GroupRepository;
import com.study.university.api.repository.StudentRepository;

import com.study.university.api.service.StudentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class StudentServiceimpl implements StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;


    @Autowired
    public StudentServiceimpl(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }


    @Override
    public StudentsDto save(StudentsDto studentDto) {
        Student student = new Student();

        student = studentDto.toStudent();


        if (studentDto.getGroup() != null) {
            Groupe groupe = groupRepository.findByName(studentDto.getGroup());
            if (groupe != null) {
                student.setGroup(groupe);
            }
        }
        student.setCreated(new Date());
        student.setUpdated(new Date());
        studentRepository.save(student);


        return StudentsDto.fromStudent(student);
    }

    @Override
    public List<StudentsDto> getAll(Integer pageNumber, Integer pageSize) {

        log.info("pageNumber-{}::::pageSize{}",pageNumber,pageSize);
        Pageable paging = PageRequest.of(pageNumber-1, pageSize, Sort.by("id").descending());

        Page<Student> result = studentRepository.findAll(paging);
        List<StudentsDto> studentsDto = new ArrayList<StudentsDto>();

        List<Student> students = result.getContent();
        students.forEach(
                x -> studentsDto.add(StudentsDto.fromStudent(x))
        );
        return studentsDto;
    }


    @Override
    public Student findById(Long id) {
        Student result = studentRepository.findById(id).orElse(null);

        if (result == null) {
            return null;
        }

        return result;
    }

}

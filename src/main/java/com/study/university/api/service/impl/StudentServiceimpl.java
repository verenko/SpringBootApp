package com.study.university.api.service.impl;


import com.study.university.api.dto.StudentsDto;
import com.study.university.api.model.Groupe;
import com.study.university.api.model.Student;

import com.study.university.api.repository.GroupRepository;
import com.study.university.api.repository.StudentRepository;

import com.study.university.api.service.StudentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

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
    public Student save(StudentsDto studentDto){
        Student student = new Student();

        student = studentDto.toStudent();
//        student.setFirstName(studentDto.getFirstName());
//        student.setLastName(studentDto.getLastName());
//        student.setPatronymicName(studentDto.getPatronymicName());
//        student.setDateBirthDay(studentDto.getDateBirthDay());
//        student.setPatronymicName(studentDto.getPatronymicName());
        if (!studentDto.getGroup().isEmpty()){
            Groupe groupe = groupRepository.findByName(studentDto.getGroup());
            if (groupe != null){
                student.setGroup(groupe);
            }
            else {
                student.setGroup(null);
            }
        }

        log.info("-----------------------------3-----------{}",student);
       return studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        List<Student> result = studentRepository.findAll();
        log.info("IN getAll - {} student found", result.size());
        return result;
    }

    @Override
    public Student findById(Long id) {
        Student result = studentRepository.findById(id).orElse(null);

        if (result == null) {
           // log.warn("IN findById - no student found by id: {}", id);
            return null;
        }

        //log.info("IN findById - student: {} found by id: {}", result);
        return result;
    }

}

package com.study.university.api.service.impl;

import com.study.university.api.model.Teacher;
import com.study.university.api.repository.GroupRepository;
import com.study.university.api.repository.StudentRepository;
import com.study.university.api.repository.TeacherRepository;
import com.study.university.api.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TeacherImpl implements TeacherService {

    private final GroupRepository groupRepository;
    private final TeacherRepository teacherRepository;

    public TeacherImpl(GroupRepository groupRepository, TeacherRepository teacherRepository) {
        this.groupRepository = groupRepository;

        this.teacherRepository = teacherRepository;
    }


    @Override
    public Teacher findById(Long id) {
        Teacher result = teacherRepository.findById(id).orElse(null);;
        return result;
    }
}

package com.study.university.api.service.impl;

import com.study.university.api.dto.GroupeDto;
import com.study.university.api.model.Groupe;

import com.study.university.api.model.Student;
import com.study.university.api.repository.GroupRepository;

import com.study.university.api.service.GroupService;
import com.study.university.api.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final StudentService studentService;


    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository, StudentService studentService) {
        this.groupRepository = groupRepository;
        this.studentService = studentService;
    }



    @Override
    public Groupe findById(Long id) {
        Groupe result = groupRepository.findById(id).orElse(null);
        if (result == null) {
            return null;
        }
        return result;
    }

    @Override
    public List<GroupeDto> getAll(Integer pageNumber, Integer pageSize) {


        Pageable paging = PageRequest.of(pageNumber - 1, pageSize, Sort.by("id").descending());


        Page<Groupe> result = groupRepository.findAll(paging);
        List<GroupeDto> groupeDto = new ArrayList<GroupeDto>();

        List<Groupe> groupe = result.getContent();






        groupe.forEach(
                x -> {
                    GroupeDto groupTemp = GroupeDto.fromGroup(x);
                    groupTemp.setCountStudent(studentService.findStudentsByGroup(x).size());
                    if (x.getStudent() != null){
                        groupTemp.setStudentName(x.getStudent().getFirstName() +" "+ x.getStudent().getLastName());
                    }
                    groupeDto.add(groupTemp);
                }
        );
        return groupeDto;
    }

    @Override
    public int countAllGroup() {
        return groupRepository.findAll().size();
    }


    @Override
    public Groupe findByIdGroup(Long id) {
        Groupe result = groupRepository.findById(id).orElse(null);
        if (result == null) {
            return null;
        }
        return result;
    }


    @Override
    public Groupe findByName(String name) {
        Groupe groupe = groupRepository.findByName(name);
        log.info("IN findByUsername - user: {} found by username: {}", groupe, name);
        return groupe;
    }



    @Override
    public Groupe save(GroupeDto groupeDto) {
        Groupe groupe = new Groupe();

        groupe = groupeDto.toGroup();
        groupe.setStudent(null);

        if (groupeDto.getStudentId() == null) {
            groupe.setStudent(null);
        } else {
            Student student = studentService.findById(groupeDto.getStudentId());

            if (student == null) {
                groupe.setStudent(null);
            } else {
                groupe.setStudent(student);
            }
        }

        groupe.setCreated(new Date());
        groupe.setUpdated(new Date());

        return groupRepository.save(groupe);
    }


}

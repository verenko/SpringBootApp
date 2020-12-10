package com.study.university.api.service.impl;

import com.study.university.api.model.Groupe;

import com.study.university.api.repository.GroupRepository;

import com.study.university.api.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;


    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Groupe> getAll() {
        List<Groupe> result = groupRepository.findAll();
        return result;
    }

    @Override
    public Groupe findById(Long id) {
        Groupe result = groupRepository.findById(id).orElse(null);
        log.info("-----------------{}",id);
        log.info("2----------------{}",result);
        if (result == null) {
            return null;
        }
        return result;
    }

}

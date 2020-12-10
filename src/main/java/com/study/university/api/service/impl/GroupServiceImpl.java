package com.study.university.api.service.impl;

import com.study.university.api.model.Group;

import com.study.university.api.repository.GroupRepository;

import com.study.university.api.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;


    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getAll() {
        List<Group> result = groupRepository.findAll();
        return result;
    }

    @Override
    public Group findById(Long id) {
        Group result = groupRepository.findById(id).orElse(null);

        if (result == null) {
            return null;
        }
        return result;
    }

}

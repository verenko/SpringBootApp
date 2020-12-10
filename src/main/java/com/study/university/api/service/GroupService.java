package com.study.university.api.service;

import com.study.university.api.model.Group;

import java.util.List;

public interface GroupService {

    List<Group> getAll();
    Group findById(Long id);

}

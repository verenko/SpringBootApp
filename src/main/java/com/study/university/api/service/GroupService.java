package com.study.university.api.service;

import com.study.university.api.dto.GroupeDto;
import com.study.university.api.model.Groupe;

import java.util.List;

public interface GroupService {

    List<GroupeDto> getAll(Integer pageNumber, Integer pageSize);

    int countAllGroup();

    Groupe findById(Long id);

    Groupe findByIdGroup(Long id);

    Groupe findByName(String name);

    Groupe save(GroupeDto groupe);


}

package com.study.university.api.service;

import com.study.university.api.dto.GroupeDto;
import com.study.university.api.dto.StudentsDto;
import com.study.university.api.model.Groupe;
import com.study.university.api.model.Student;

import java.util.List;

public interface GroupService {

    List<Groupe> getAll();

    Groupe findById(Long id);

    Groupe findByIdGroup(Long id);

    Groupe findByName(String name);

    Groupe save(GroupeDto groupe);

}

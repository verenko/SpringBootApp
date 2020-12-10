package com.study.university.api.service;

import com.study.university.api.model.Groupe;

import java.util.List;

public interface GroupService {

    List<Groupe> getAll();
    Groupe findById(Long id);

}

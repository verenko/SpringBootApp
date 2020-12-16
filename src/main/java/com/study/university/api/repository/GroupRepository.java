package com.study.university.api.repository;

import com.study.university.api.model.Groupe;
import com.study.university.api.model.Student;
import com.study.university.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Groupe, Long> {
    Groupe findByName(String name);

}

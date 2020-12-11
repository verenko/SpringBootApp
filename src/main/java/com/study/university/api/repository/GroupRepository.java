package com.study.university.api.repository;

import com.study.university.api.model.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Groupe, Long> {

}

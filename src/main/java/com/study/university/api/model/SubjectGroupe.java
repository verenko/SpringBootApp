package com.study.university.api.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subject_to_groupe")
@Data
public class SubjectGroupe extends BaseTwoEntity {
    @Column(nullable = false)
    @Column(nullable = false)
    @Column(nullable = false)

}

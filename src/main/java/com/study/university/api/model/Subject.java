package com.study.university.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
@Data
public class Subject extends BaseTwoEntity {

    @Column(nullable = false)
    private String name;

}

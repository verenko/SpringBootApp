package com.study.university.api.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "score")
@Data
public class Score extends BaseTwoEntity {

    @Column(nullable = false)
    private int value;



}

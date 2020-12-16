package com.study.university.api.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "student")
@Data
public class Student extends BaseTwoEntity {
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String patronymicName;
    @Column(nullable = false)
    private Date dateBirthDay;
    @Column(nullable = false)
    private String recordNumber;

    private int isActive;


    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "groupe_id", nullable = true)
    private Groupe group;

}

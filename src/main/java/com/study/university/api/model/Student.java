package com.study.university.api.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "students")
@Data
public class Student extends BaseTwoEntity implements Serializable {
    @Column(nullable = false)
    private String fistName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String patronymicName;
    @Column(nullable = false)
    private Date dateBirthDay;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "group_id", nullable = false)
    private Groupe group;


}

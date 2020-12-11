package com.study.university.api.model;


import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;
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

    @Nullable
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "groupe_id", nullable = true)
    private Groupe group;



}

package com.study.university.api.model;


import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "groups_university")
@Data
public class Groupe extends BaseTwoEntity implements Serializable {
    @Column(nullable = false)
    private String name;


    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "main_person", nullable = true)
    private Student student;

}

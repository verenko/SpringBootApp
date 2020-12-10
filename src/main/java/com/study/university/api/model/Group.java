package com.study.university.api.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "groupe")
@Data
public class Group extends BaseTwoEntity  {
    @Column(nullable = false)
    private String name;

}

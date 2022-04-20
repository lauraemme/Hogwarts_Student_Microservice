package com.hogwarts.studentsHandler.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter  @Setter
@Entity
@Table(name = "student")
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "name")
        private String name;

        @Column(name = "year")
        private Integer year;

        @ManyToOne
        @JoinColumn(name = "id_house")
        private House house;

}

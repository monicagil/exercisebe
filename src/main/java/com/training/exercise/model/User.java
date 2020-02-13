package com.training.exercise.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    public enum Gender {
        MALE, FEMALE, OTHER
    }

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "directory")
    private String dir;

    @Column(name = "email")
    private String email;
}

package com.training.exercise.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDTO {
    public enum Sex {
        MALE, FEMALE
    }

    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String userName;

    @NotBlank
    @NotNull
    @Size(max = 75)
    private String name;

    private int age;

    @NotBlank
    @NotNull
    private Sex gender;

    private String dir;

    private String email;

}

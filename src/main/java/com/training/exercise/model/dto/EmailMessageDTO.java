package com.training.exercise.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EmailMessageDTO {
    @NotBlank
    @NotNull
    String from;

    @NotBlank
    @NotNull
    String recipient;

    @NotBlank
    @NotNull
    String subject;

    @NotBlank
    @NotNull
    String content;

    String host;

    int port;
}

package com.training.exercise.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class EmailMessageDTO {

    private Long id;

    private UserDTO fromUserDTO;

    private UserDTO recipientUserDTO;

    @NotBlank
    @NotNull
    String subject;

    @NotBlank
    @NotNull
    String content;

    String host;

    int port;
}

package com.training.exercise.controller;

import com.training.exercise.mapper.UserMapper;
import com.training.exercise.model.User;
import com.training.exercise.model.dto.UserDTO;
import com.training.exercise.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {

    protected final UserMapper userMapper;
    protected final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        this.userMapper = Mappers.getMapper(UserMapper.class);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> createUser(
            @Valid
            @NotNull
            @RequestBody UserDTO userDTO) {
        User user = userMapper.createEntityFromUserDTO(userDTO);
        User persistedUser = userService.createUser(user);
        return ResponseEntity.ok(userMapper.createDtoFromEntity(persistedUser));
    }
}

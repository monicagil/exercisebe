package com.training.exercise.mapper;

import com.training.exercise.model.User;
import com.training.exercise.model.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User createEntityFromUserDTO(UserDTO userDTO);
    UserDTO createDtoFromEntity(User user);
}

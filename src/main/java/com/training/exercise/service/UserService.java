package com.training.exercise.service;

import com.training.exercise.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<User> findAll(Pageable pageable);

    User findById(Long userId);

    User createUser(User user);
}

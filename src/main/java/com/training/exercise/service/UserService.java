package com.training.exercise.service;

import com.training.exercise.model.FilterCriteria;
import com.training.exercise.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface UserService {

    Page<User> findAll(Pageable pageable);

    User findById(Long userId);

    User createUser(User user);

    User findByEmail(String email);

    Page<User> searchBy(Set<FilterCriteria> filters, Pageable pageable);
}

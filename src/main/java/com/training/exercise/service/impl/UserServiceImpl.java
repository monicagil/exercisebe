package com.training.exercise.service.impl;

import com.training.exercise.mapper.UserMapper;
import com.training.exercise.model.User;
import com.training.exercise.persistence.RepositoryResolver;
import com.training.exercise.persistence.UserRepository;
import com.training.exercise.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(RepositoryResolver repositoryResolver, UserMapper userMapper) {
        this.userRepository = repositoryResolver.get(UserRepository.class);
        this.userMapper = userMapper;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(null);
    }

    @Override
    public User createUser(User user) {
        User userToCreate;
        userToCreate = new User();
        userToCreate.setAge(user.getAge());
        userToCreate.setName(user.getName());
        userToCreate.setUserName(user.getUserName());
        userToCreate.setDir(user.getDir());
        userToCreate.setGender(user.getGender());
        return userRepository.save(userToCreate);
    }
}

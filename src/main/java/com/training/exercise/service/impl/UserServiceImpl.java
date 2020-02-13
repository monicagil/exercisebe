package com.training.exercise.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.training.exercise.mapper.UserMapper;
import com.training.exercise.model.FilterCriteria;
import com.training.exercise.model.User;
import com.training.exercise.persistence.RepositoryResolver;
import com.training.exercise.persistence.UserRepository;
import com.training.exercise.persistence.predicate.UserPredicate;
import com.training.exercise.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserPredicate userPredicate;

    @Autowired
    public UserServiceImpl(RepositoryResolver repositoryResolver, UserPredicate userPredicate) {
        this.userRepository = repositoryResolver.get(UserRepository.class);
        this.userMapper = Mappers.getMapper(UserMapper.class);
        this.userPredicate = userPredicate;
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

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Page<User> searchBy(Set<FilterCriteria> filters, Pageable pageable) {
        if (CollectionUtils.isEmpty(filters)) {
            return userRepository.findAll(pageable);
        }
        BooleanExpression result = userPredicate.getPredicate(filters);
        return userRepository.findAll(result, pageable);
    }

}

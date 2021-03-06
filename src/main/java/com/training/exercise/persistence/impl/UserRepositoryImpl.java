package com.training.exercise.persistence.impl;

import com.training.exercise.model.User;
import com.training.exercise.persistence.QueryDslRepositorySupport;
import com.training.exercise.persistence.UserRepositoryCustom;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

@Repository
public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom {
    public UserRepositoryImpl(EntityManager entityManager) {
        super(User.class, entityManager);
    }
}

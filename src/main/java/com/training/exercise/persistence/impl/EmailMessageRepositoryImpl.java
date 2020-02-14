package com.training.exercise.persistence.impl;

import com.training.exercise.model.EmailMessage;
import com.training.exercise.persistence.EmailMessageRepositoryCustom;
import com.training.exercise.persistence.QueryDslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EmailMessageRepositoryImpl extends QueryDslRepositorySupport implements EmailMessageRepositoryCustom  {
    public EmailMessageRepositoryImpl(EntityManager entityManager) {
        super(EmailMessage.class, entityManager);
    }
}

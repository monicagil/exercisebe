package com.training.exercise.persistence;

import com.training.exercise.model.EmailMessage;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmailMessageRepository  extends PagingAndSortingRepository<EmailMessage, Long>,
        EmailMessageRepositoryCustom, QuerydslPredicateExecutor<EmailMessage> {
}

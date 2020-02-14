package com.training.exercise.persistence;

import com.training.exercise.model.EmailMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmailMessageRepository  extends PagingAndSortingRepository<EmailMessage, Long>,
        EmailMessageRepositoryCustom, QuerydslPredicateExecutor<EmailMessage> {

    @Query("SELECT e FROM EmailMessage e WHERE e.fromId = :id")
    List<EmailMessage> findByFromId(@Param("id") Long id);

    @Query("SELECT e FROM EmailMessage e WHERE e.recipientId = :id")
    List<EmailMessage> findByRecipientId(@Param("id") Long id);
}

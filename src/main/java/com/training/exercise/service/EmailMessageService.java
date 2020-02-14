package com.training.exercise.service;

import com.training.exercise.model.EmailMessage;

import java.util.List;


public interface EmailMessageService {
    List<EmailMessage> findByFromId(Long fromId);

    List<EmailMessage> findByRecipientId(Long fromId);
}

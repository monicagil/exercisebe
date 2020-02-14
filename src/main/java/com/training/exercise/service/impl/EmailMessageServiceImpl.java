package com.training.exercise.service.impl;

import com.training.exercise.model.EmailMessage;
import com.training.exercise.service.EmailMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmailMessageServiceImpl implements EmailMessageService {
    @Override
    public List<EmailMessage> findByFromId(Long fromId) {
        return null;
    }

    @Override
    public List<EmailMessage> findByRecipientId(Long fromId) {
        return null;
    }
}

package com.training.exercise.service.impl;

import com.training.exercise.mapper.MessageMapper;
import com.training.exercise.model.EmailMessage;
import com.training.exercise.model.User;
import com.training.exercise.persistence.EmailMessageRepository;
import com.training.exercise.service.EmailMessageService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Service
@Slf4j
public class EmailMessageServiceImpl implements EmailMessageService {
    private final EmailMessageRepository emailMessageRepository;
    private final MessageMapper messageMapper;

    public EmailMessageServiceImpl(EmailMessageRepository emailMessageRepository) {
        this.emailMessageRepository = emailMessageRepository;
        this.messageMapper = Mappers.getMapper(MessageMapper.class);
    }

    @Override
    public List<EmailMessage> findByFromId(Long fromId) {
        return emailMessageRepository.findByFromId(fromId);
    }

    @Override
    public List<EmailMessage> findByRecipientId(Long fromId) {
        return emailMessageRepository.findByRecipientId(fromId);
    }

    @Override
    public void sendEmail(User userFromId, User userToId, String content) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props);
        String toEmail = userToId.getEmail();
        String fromEmail = userFromId.getEmail();
        String text = content;
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Test");
            message.setText(content);
            Transport t = session.getTransport("smtp");
            t.connect("monicagilcastro@gmail.com", "password");
            t.sendMessage(message, message.getAllRecipients());
            t.close();
        } catch (MessagingException me) {
            return;
        }
    }
}

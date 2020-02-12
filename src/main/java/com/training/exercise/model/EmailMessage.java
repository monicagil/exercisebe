package com.training.exercise.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "message")
public class EmailMessage {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from")
    String from;

    @Column(name = "recipient")
    String recipient;

    @Column(name = "subject")
    String subject;

    @Column(name = "content")
    String content;

    @Column(name = "host")
    String host;

    @Column(name = "port")
    int port;
}

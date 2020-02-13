package com.training.exercise.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "message")
public class EmailMessage {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    private User fromId;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    private User recipientId;

    @Column(name = "subject")
    String subject;

    @Column(name = "content")
    String content;

    @Column(name = "host")
    String host;

    @Column(name = "port")
    int port;
}

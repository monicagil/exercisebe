package com.training.exercise.persistence.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@ComponentScan(basePackages = {"com.training.exercise"})
@EnableJpaRepositories(
        basePackages = {"com.training.exercise.persistence"})

public class JPAConfig {

        }

package com.training.exercise.persistence.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;


@Configuration
@ComponentScan(basePackages = {"com.training.exercise.persistence"})
@EnableJpaRepositories(
        basePackages = {"com.training.exercise.persistence"},
        includeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE, classes = PagingAndSortingRepository.class))
public class JPAConfig {

        }

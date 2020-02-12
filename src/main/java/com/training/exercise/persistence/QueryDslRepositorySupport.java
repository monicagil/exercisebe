package com.training.exercise.persistence;

import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.PathBuilderFactory;
import lombok.Getter;
import org.springframework.data.jpa.repository.support.Querydsl;

import javax.persistence.EntityManager;

public abstract class QueryDslRepositorySupport {
    @Getter
    private final PathBuilder<?> builder;

    @Getter
    private final Querydsl querydsl;

    @Getter
    private final EntityManager entityManager;

    public QueryDslRepositorySupport(Class clazz, EntityManager entityManager) {
        this.entityManager = entityManager;
        this.builder = new PathBuilderFactory().create(clazz);
        this.querydsl = new Querydsl(entityManager, builder);
    }
}

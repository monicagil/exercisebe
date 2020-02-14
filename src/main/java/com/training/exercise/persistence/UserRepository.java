package com.training.exercise.persistence;

import com.training.exercise.model.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long>,
        QuerydslPredicateExecutor<User>, UserRepositoryCustom {

    User findByEmail(String email);
}

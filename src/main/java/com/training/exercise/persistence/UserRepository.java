package com.training.exercise.persistence;

import com.training.exercise.model.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<User, Long>,
        QuerydslPredicateExecutor<User>, UserRepositoryCustom {

    Optional<User> findByEmail(String email);
}

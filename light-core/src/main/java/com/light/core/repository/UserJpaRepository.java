package com.light.core.repository;

import com.light.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserJpaRepository extends JpaRepository<User,Long>,QueryDslPredicateExecutor<User> {

}
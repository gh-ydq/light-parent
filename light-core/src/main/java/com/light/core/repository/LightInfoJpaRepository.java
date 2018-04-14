package com.light.core.repository;

import com.light.core.entity.LightInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface LightInfoJpaRepository extends JpaRepository<LightInfo,Long>,QueryDslPredicateExecutor<LightInfo> {

}
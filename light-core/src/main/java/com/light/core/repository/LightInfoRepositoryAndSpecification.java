package com.light.core.repository;

import com.light.core.entity.LightInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface LightInfoRepositoryAndSpecification extends JpaRepository<LightInfo,Long>,JpaSpecificationExecutor<LightInfo> {

}
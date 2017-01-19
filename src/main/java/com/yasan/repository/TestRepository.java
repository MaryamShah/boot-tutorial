package com.yasan.repository;

import com.yasan.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Maryam.
 */
public interface TestRepository extends JpaRepository<TestEntity, Long>, QueryDslPredicateExecutor {

}

package com.yasan.repository;

import com.yasan.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by pooya on 1/13/17.
 */
public interface SampleRepository extends JpaRepository<SampleEntity, Long>, QueryDslPredicateExecutor {

}

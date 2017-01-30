package com.yasan.services;

import com.yasan.entity.TestEntity;
import com.yasan.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Maryam.
 */

@Service
public class TestService {


    @Autowired
    private TestRepository repository;

    public TestEntity add(TestEntity entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public void update(TestEntity entity) {
        if (repository.exists(entity.getId())) {
            repository.save(entity);
        }

    }

    public TestEntity search(TestEntity entity) {
        return repository.findOne(entity.getId());
    }

    public TestEntity searchById(Long id) {
        return repository.findOne(id);
    }
}

package com.yasan.services;

import com.yasan.entity.QSampleEntity;
import com.yasan.entity.SampleEntity;
import com.yasan.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pooya on 1/13/17.
 */

@Service
public class SampleService {

    private static final QSampleEntity Q = QSampleEntity.sampleEntity;

    @Autowired
    private SampleRepository repository;

    public SampleEntity add(SampleEntity entity) {
        return repository.save(entity);
    }

    public Iterable<SampleEntity> search(SampleEntity entity) {
        return repository.findAll(Q.family.like("%"+entity.getFamily()+"%"));
//        return repository.findAll(Q.family.like(entity.getFamily()));
    }

}

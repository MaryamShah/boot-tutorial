package com.yasan.transformer;

import com.yasan.dto.TestDto;
import com.yasan.entity.TestEntity;
import org.springframework.stereotype.Component;

/**
 * Created by Maryam.
 */

@Component
public class TestDtoTransformer extends BeanTransformer<TestDto, TestEntity> {


    @Override
    public TestEntity convert(TestDto testDto, Object parent) {
        TestEntity testEntity = new TestEntity();

        testEntity.setId(testDto.getId());
        testEntity.setCourse(testDto.getCourse());
        testEntity.setGrade(testDto.getGrade());

        return testEntity;
    }
}
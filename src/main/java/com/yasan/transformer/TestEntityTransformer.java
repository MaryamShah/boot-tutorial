package com.yasan.transformer;

import com.yasan.dto.TestDto;
import com.yasan.entity.TestEntity;
import org.springframework.stereotype.Component;

/**
 * Created by Maryam.
 */

@Component
public class TestEntityTransformer extends BeanTransformer<TestEntity, TestDto> {


    @Override
    public TestDto convert(TestEntity source, Object parent) {
        TestDto dto = new TestDto();

        dto.setId(source.getId());
        dto.setCourse(source.getCourse());
        dto.setGrade(source.getGrade());

        return dto;
    }
}
package com.yasan.transformer;

import com.yasan.dto.SampleDto;
import com.yasan.entity.SampleEntity;
import org.springframework.stereotype.Component;

/**
 * Created by pooya on 1/13/17.
 */

@Component
public class SampleDtoTransformer extends BeanTransformer<SampleDto, SampleEntity> {


    @Override
    public SampleEntity convert(SampleDto sampleDto, Object parent) {
        SampleEntity sampleEntity = new SampleEntity();

        sampleEntity.setFamily(sampleDto.getFamily());
        sampleEntity.setId(sampleDto.getId());
        sampleEntity.setName(sampleDto.getName());
        return sampleEntity;
    }
}
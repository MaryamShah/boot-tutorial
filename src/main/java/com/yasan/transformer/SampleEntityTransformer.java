package com.yasan.transformer;

import com.yasan.dto.SampleDto;
import com.yasan.entity.SampleEntity;
import org.springframework.stereotype.Component;

/**
 * Created by pooya on 1/13/17.
 */

@Component
public class SampleEntityTransformer extends BeanTransformer<SampleEntity,SampleDto> {


    @Override
    public SampleDto convert(SampleEntity source, Object parent) {
        SampleDto dto = new SampleDto();

        dto.setFamily(source.getFamily());
        dto.setId(source.getId());
        dto.setName(source.getName());
        return dto;
    }
}
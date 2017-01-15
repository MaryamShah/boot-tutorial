package com.yasan.rests;

import com.yasan.dto.SampleDto;
import com.yasan.entity.SampleEntity;
import com.yasan.services.SampleService;
import com.yasan.transformer.BasicTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pooya on 1/13/17.
 */

@RestController
@RequestMapping("/com/yasan/")
@Transactional
public class SampleRestService {

    @Autowired
    private SampleService sampleService;
    @Autowired
    private BasicTransformer transformer;

    @RequestMapping(method = RequestMethod.POST)
    public SampleDto add(@RequestBody SampleDto sampleDto) {
        SampleEntity result = sampleService.add(transformer.convert(sampleDto, SampleEntity.class));
        return transformer.convert(result, SampleDto.class);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(Long id, SampleDto dto) {

    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<SampleDto> search(@RequestBody SampleDto sampleDto) {
        Iterable<SampleEntity> result = sampleService.search(transformer.convert(sampleDto, SampleEntity.class));
        return transformer.convert(result,SampleDto.class);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(Long id) {

    }
}

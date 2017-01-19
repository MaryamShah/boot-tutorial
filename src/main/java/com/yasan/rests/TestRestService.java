package com.yasan.rests;

import com.yasan.dto.TestDto;
import com.yasan.entity.TestEntity;
import com.yasan.services.TestService;
import com.yasan.transformer.BasicTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Maryam.
 */

@RestController
@RequestMapping("/com/yasan/test")
@Transactional
public class TestRestService {

    @Autowired
    private TestService testService;
    @Autowired
    private BasicTransformer transformer;

    @RequestMapping(method = RequestMethod.POST)
    public TestDto add(@RequestBody TestDto testDto) {
        TestEntity result = testService.add(transformer.convert(testDto, TestEntity.class));
        return transformer.convert(result, TestDto.class);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(Long id, TestDto dto) {
        TestEntity result = testService.searchById(id);
        result.setCourse(dto.getCourse());
        result.setGrade(dto.getGrade());
        testService.update(result);
    }

    @RequestMapping(value = "/searchOne", method = RequestMethod.POST)
    public TestDto search(@RequestBody TestDto testDto) {
        TestEntity result = testService.search(transformer.convert(testDto, TestEntity.class));
        return transformer.convert(result, TestDto.class);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(Long id) {
        testService.delete(id);
    }
}

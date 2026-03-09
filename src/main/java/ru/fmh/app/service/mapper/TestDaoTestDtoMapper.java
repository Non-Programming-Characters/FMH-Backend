package com.example.demo.service.mapper;

import com.example.demo.common.Mapper;
import com.example.demo.dao.TestDao;
import com.example.demo.dto.TestDto;
import org.springframework.stereotype.Component;

@Component
public class TestDaoTestDtoMapper implements Mapper<TestDto, TestDao> {

    @Override
    public TestDao mapToInfra(TestDto domainEntity) {
        return TestDao.builder()
                .id(domainEntity.getId())
                .title(domainEntity.getTitle())
                .answerMask(domainEntity.getAnswerMask())
                .questions(domainEntity.getQuestions())
                .build();
    }

    @Override
    public TestDto mapToDomain(TestDao infraEntity) {
        return TestDto.builder()
                .id(infraEntity.getId())
                .title(infraEntity.getTitle())
                .answerMask(infraEntity.getAnswerMask())
                .questions(infraEntity.getQuestions())
                .build();
    }
}
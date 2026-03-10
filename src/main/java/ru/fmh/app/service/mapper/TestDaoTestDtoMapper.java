package ru.fmh.app.service.mapper;

import ru.fmh.app.common.Mapper;
import ru.fmh.app.dao.TestDao;
import ru.fmh.app.dto.TestDto;
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
package ru.fmh.app.service.mapper;

import org.springframework.stereotype.Component;
import ru.fmh.app.common.Mapper;
import ru.fmh.app.dao.TestUserHistoryDao;
import ru.fmh.app.dto.TestUserHistoryDto;

@Component
public class TestHistoryDtoUserTestHistoryDaoMapper implements Mapper<TestUserHistoryDto, TestUserHistoryDao> {

    @Override
    public TestUserHistoryDao mapToInfra(TestUserHistoryDto domainEntity) {
        return TestUserHistoryDao.builder()
                .id(domainEntity.getId())
                .testId(domainEntity.getTestId())
                .passedUserId(domainEntity.getPassedUserId())
                .createdAt(domainEntity.getCreatedAt())
                .result(domainEntity.getResult())
                .build();
    }

    @Override
    public TestUserHistoryDto mapToDomain(TestUserHistoryDao infraEntity) {
        return TestUserHistoryDto.builder()
                .id(infraEntity.getId())
                .testId(infraEntity.getTestId())
                .passedUserId(infraEntity.getPassedUserId())
                .createdAt(infraEntity.getCreatedAt())
                .result(infraEntity.getResult())
                .build();
    }
}
package com.example.demo.service.mapper;

import com.example.demo.common.Mapper;
import com.example.demo.dao.TestUserHistoryDao;
import com.example.demo.dto.TestUserHistoryDto;
import org.springframework.stereotype.Component;

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
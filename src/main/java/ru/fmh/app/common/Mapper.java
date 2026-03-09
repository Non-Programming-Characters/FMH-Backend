package com.example.demo.common;

public interface Mapper<D, I> {

    I mapToInfra(D domainEntity);

    D mapToDomain(I infraEntity);
}

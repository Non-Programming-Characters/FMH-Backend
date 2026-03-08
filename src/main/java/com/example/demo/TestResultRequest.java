package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestResultRequest {
    
    private UUID id;

    
    @JsonProperty("user-id")
    private UUID userId;

    
    @JsonProperty("total-questions")
    private Integer totalQuestions;

    
    private Integer result;

    
    @JsonProperty("approved-at")
    private String approvedAt;
}
package org.codeOn.InterviewHub.interview.dto;

public record RoundResponse(
    Long id,
    String name,
    Integer sequence,
    String description
) {}

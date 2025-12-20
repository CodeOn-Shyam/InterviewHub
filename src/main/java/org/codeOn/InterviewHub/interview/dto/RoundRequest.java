package org.codeOn.InterviewHub.interview.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
public record RoundRequest(
    @NotBlank String name,
    @NotNull Integer sequence,
    String description
) {}

package org.codeOn.InterviewHub.interview.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
public record CreateDriveRequest(@NotBlank String title,
     String description,
     @NotNull LocalDate date
    ){}

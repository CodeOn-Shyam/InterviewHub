package org.codeOn.InterviewHub.interview.dto;

import java.time.LocalDate;

public record DriveResponse (
    Long id,
    String title,
    String description,
    LocalDate date
){
}

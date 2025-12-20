package org.codeOn.InterviewHub.interview.controller;

import org.codeOn.InterviewHub.interview.dto.DriveResponse;
import org.codeOn.InterviewHub.interview.service.InterviewDriveService;
import org.codeOn.InterviewHub.interview.dto.CreateDriveRequest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.codeOn.InterviewHub.interview.dto.UpdateDriveRequest;

@RestController
@RequestMapping("/api/drives")
@RequiredArgsConstructor
public class InterviewDriveController {
    private InterviewDriveService interviewDriveService;

    @PostMapping
    @PreAuthorize("hasRole('RECRUITER')")
    public DriveResponse createDrive(@Valid @RequestBody CreateDriveRequest request) {
        return interviewDriveService.create(request);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('RECRUITER')")
    public DriveResponse updateDrive(@PathVariable Long id, @Valid @RequestBody UpdateDriveRequest request) {
        return interviewDriveService.update(id, request);
    }
}
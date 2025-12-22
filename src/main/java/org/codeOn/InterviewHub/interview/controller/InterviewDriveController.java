package org.codeOn.InterviewHub.interview.controller;

import org.codeOn.InterviewHub.interview.dto.DriveResponse;
import org.codeOn.InterviewHub.interview.service.InterviewDriveService;

import java.util.List;

import org.codeOn.InterviewHub.interview.dto.CreateDriveRequest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.codeOn.InterviewHub.interview.dto.UpdateDriveRequest;
import org.codeOn.InterviewHub.interview.model.InterviewDrive;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/drives")
@RequiredArgsConstructor
public class InterviewDriveController {
    private final InterviewDriveService interviewDriveService;

    @PostMapping
    @PreAuthorize("hasRole('RECRUITER')")
    public DriveResponse createDrive(@Valid @RequestBody CreateDriveRequest request) {
        return interviewDriveService.create(request);
    }
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('RECRUITER')")
    public DriveResponse updateDrive(@PathVariable Long id, @Valid @RequestBody UpdateDriveRequest request) {
        return interviewDriveService.update(request,id);
    }

    @GetMapping("/{id}")
    public DriveResponse getDrive(@PathVariable Long id) {
        return interviewDriveService.get(id);
    }

    @GetMapping
    public List<InterviewDrive> getAllDrives() {
        return interviewDriveService.getAll();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('RECRUITER')")
    public void deleteDrive(@PathVariable Long id) {
        interviewDriveService.delete(id);
    }
    
}
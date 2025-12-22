package org.codeOn.InterviewHub.interview.controller;

import org.codeOn.InterviewHub.interview.dto.RoundRequest;
import org.codeOn.InterviewHub.interview.dto.RoundResponse;
import org.codeOn.InterviewHub.interview.service.InterviewRoundService;
import org.codeOn.InterviewHub.interview.model.InterviewRound;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

import java.util.List;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class InterviewRoundController {
	private final InterviewRoundService interviewRoundService;

    @PostMapping("/drives/{driveId}/rounds")
    @PreAuthorize("hasRole('RECRUITER')")
    public RoundResponse createInterviewRound(@PathVariable Long driveId,@Valid @RequestBody RoundRequest request) {
        return interviewRoundService.createRound(driveId, request);
    }
    @GetMapping("drives/{driveId}/rounds")
    public List<InterviewRound> getRounds(@PathVariable Long driveId){
        return interviewRoundService.getRoundsByDriveId(driveId);
    }
    @DeleteMapping("/rounds/{roundId}")
    @PreAuthorize("hasRole('RECRUITER')")
    public void delete(@PathVariable Long roundId){
        interviewRoundService.delete(roundId);
    }
}

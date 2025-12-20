package org.codeOn.InterviewHub.interview.service;

import org.codeOn.InterviewHub.interview.dto.RoundResponse;
import org.codeOn.InterviewHub.interview.repository.InterviewDriveRepository;
import org.codeOn.InterviewHub.interview.repository.InterviewRoundRepository;
import org.codeOn.InterviewHub.interview.dto.RoundRequest;
import org.codeOn.InterviewHub.interview.model.InterviewRound;
import org.codeOn.InterviewHub.interview.model.InterviewDrive;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InterviewRoundService {
    private final InterviewRoundRepository interviewRoundRepository;
    private final InterviewDriveRepository interviewDriveRepository;
    public RoundResponse create(Long driveId,RoundRequest request) {
        InterviewDrive interviewDrive = interviewDriveRepository.findById(driveId).orElseThrow(()-> new RuntimeException("Interview drive not found"));
        InterviewRound round = new InterviewRound();
        round.setName(request.name());
        round.setDescription(request.description());
        round.setSequence(request.sequence());
        round.setInterviewDrive(interviewDrive);
        InterviewRound savedRound = interviewRoundRepository.save(round);
        return new RoundResponse(
            savedRound.getId(),
            savedRound.getName(),
            savedRound.getSequence(),
            savedRound.getDescription()
        );
    }
}

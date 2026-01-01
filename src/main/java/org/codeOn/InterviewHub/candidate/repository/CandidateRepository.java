package org.codeOn.InterviewHub.candidate.repository;

import org.codeOn.InterviewHub.candidate.model.Candidate;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findByInterviewDriveId(Long driveId);
    boolean existsByEmailAndInterviewDriveId(String email, Long driveId);
}

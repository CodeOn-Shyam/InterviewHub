package org.codeOn.InterviewHub.interview.repository;
import org.codeOn.InterviewHub.interview.model.InterviewRound;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface InterviewRoundRepository extends JpaRepository<InterviewRound, Long> {
    List<InterviewRound> findByInterviewDriveId(Long driveId);
}

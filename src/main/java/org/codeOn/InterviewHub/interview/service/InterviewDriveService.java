package org.codeOn.InterviewHub.interview.service;
import org.springframework.stereotype.Service;

import org.codeOn.InterviewHub.interview.repository.InterviewDriveRepository;
import org.codeOn.InterviewHub.interview.dto.CreateDriveRequest;
import org.codeOn.InterviewHub.interview.dto.DriveResponse;
import org.codeOn.InterviewHub.interview.model.InterviewDrive;
import org.codeOn.InterviewHub.interview.dto.UpdateDriveRequest;
import lombok.RequiredArgsConstructor;

import java.util.List;
@Service
@RequiredArgsConstructor
public class InterviewDriveService {
    private final InterviewDriveRepository interviewDriveRepository;
    
    public DriveResponse create(CreateDriveRequest request){
        InterviewDrive drive = new InterviewDrive();
        drive.setTitle(request.title());
        drive.setDescription(request.description());
        drive.setDate(request.date());
        interviewDriveRepository.save(drive);
        return new DriveResponse(
            drive.getId(),
            drive.getTitle(),
            drive.getDescription(),
            drive.getDate()
        );
    }
    public DriveResponse update(UpdateDriveRequest request, Long id){
        InterviewDrive drive = interviewDriveRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Drive not found"));
        drive.setTitle(request.title());
        drive.setDescription(request.description());
        drive.setDate(request.date());
        interviewDriveRepository.save(drive);
        return new DriveResponse(
            drive.getId(),
            drive.getTitle(),
            drive.getDescription(),
            drive.getDate()
        );
    }
    public DriveResponse get(Long id){
        InterviewDrive drive =  interviewDriveRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Drive not found"));
            return new DriveResponse(
                drive.getId(),
                drive.getTitle(),
                drive.getDescription(),
                drive.getDate()
            );
    }
    public List<InterviewDrive> getAll(){
        return interviewDriveRepository.findAll();
    }
    public void delete(Long id){
        interviewDriveRepository.deleteById(id);
    }
}

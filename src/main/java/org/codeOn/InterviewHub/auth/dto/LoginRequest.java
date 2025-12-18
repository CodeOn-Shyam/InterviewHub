package org.codeOn.InterviewHub.auth.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @Email
    @NotBlank
    String email;

    @NotBlank
    String password;
}

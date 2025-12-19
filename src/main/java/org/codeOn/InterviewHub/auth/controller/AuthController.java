package org.codeOn.InterviewHub.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.codeOn.InterviewHub.auth.dto.LoginResponse;
import org.codeOn.InterviewHub.auth.service.AuthService;
import org.codeOn.InterviewHub.auth.dto.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }

}

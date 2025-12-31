package org.codeOn.InterviewHub.common.response;

import java.time.LocalDateTime;

public record ApiResponse<T>(
    boolean success, 
    String message,
     T data,
     String errorCode,
    LocalDateTime timestamp
    ) {
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data, null, LocalDateTime.now());
    }
    public static <T> ApiResponse<T> failure(String message, String errorCode) {
        return new ApiResponse<>(false, message, null, errorCode, LocalDateTime.now());
    }
    
}

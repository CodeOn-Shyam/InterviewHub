package org.codeOn.InterviewHub.common.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.codeOn.InterviewHub.common.response.ApiResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
        body(ApiResponse.failure(ex.getMessage(), "NOT_FOUND"));
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<?>> handleBusinessException(BusinessException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).
        body(ApiResponse.failure(ex.getMessage(), "BUSINESS_ERROR"));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
        .map(err-> err.getField()+": "+err.getDefaultMessage())
        .findFirst()
        .orElse("Validation error");
        return ResponseEntity.badRequest().body(ApiResponse.failure(message, "VALIDATION_ERROR"));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
            ApiResponse.failure("Something went wrong", "INTERNAL_SERVER_ERROR")
        );
    }
}

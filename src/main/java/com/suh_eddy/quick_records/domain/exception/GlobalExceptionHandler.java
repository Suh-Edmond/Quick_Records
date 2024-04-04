package com.suh_eddy.quick_records.domain.exception;

import com.suh_eddy.quick_records.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

import static com.suh_eddy.quick_records.domain.constant.ErrorCodes.*;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {ResourceNotFoundException.class}) // 404
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(RESOURCE_NOT_FOUND.name());
        errorResponse.setMessage(RESOURCE_NOT_FOUND.getMessage());
        errorResponse.setDetail(ex.getMessage());
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setTimestamp(new Date());
        errorResponse.setErrors(null);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ResourceAlreadyExistException.class}) // 409
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExistException(ResourceAlreadyExistException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(RESOURCE_ALREADY_EXIST.name());
        errorResponse.setMessage(RESOURCE_ALREADY_EXIST.getMessage());
        errorResponse.setDetail(ex.getMessage());
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setTimestamp(new Date());
        errorResponse.setErrors(null);
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class}) // 400
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(INVALID_FORMAT.name());
        errorResponse.setMessage(INVALID_FORMAT.getMessage());
        errorResponse.setDetail(ex.getMessage());
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setTimestamp(new Date());
        errorResponse.setErrors(null);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {AccessDeniedException.class}) //401
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ACCESS_DENIED.name());
        errorResponse.setMessage(ACCESS_DENIED.getMessage());
        errorResponse.setDetail(ex.getMessage());
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setTimestamp(new Date());
        errorResponse.setErrors(null);
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {AuthorizationException.class}) //403
    public ResponseEntity<ErrorResponse> handleAuthorizationException(AuthorizationException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ACCESS_FORBIDDEN.name());
        errorResponse.setMessage(ACCESS_FORBIDDEN.getMessage());
        errorResponse.setDetail(ex.getMessage());
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setTimestamp(new Date());
        errorResponse.setErrors(null);
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(value = {BusinessValidationException.class}) //400
    public ResponseEntity<ErrorResponse> handleBusinessValidationException(BusinessValidationException ex, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(VALIDATION_ERROR.name());
        errorResponse.setMessage(VALIDATION_ERROR.getMessage());
        errorResponse.setDetail(ex.getMessage());
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setTimestamp(new Date());
        errorResponse.setErrors(null);
        return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class}) //400
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                                               HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(VALIDATION_ERROR.name());
        errorResponse.setMessage(VALIDATION_ERROR.getMessage());
        errorResponse.setDetail(ex.getMessage());
        errorResponse.setPath(request.getRequestURI());
        errorResponse.setTimestamp(new Date());

        List<FieldError> fieldErrorList = ex.getBindingResult().getFieldErrors();
        StringBuilder message = new StringBuilder();

        for (FieldError fieldError : fieldErrorList) {
            errorResponse.addError(new ErrorResponse.ErrorItem(fieldError.getField(), fieldError.getDefaultMessage()));
            message.append(" #").append(fieldError.getField());
        }
        errorResponse.setMessage(message.toString());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

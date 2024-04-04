package com.suh_eddy.quick_records.domain.constant;

public enum ErrorCodes {

    RESOURCE_NOT_FOUND("Resource not found"),
    RESOURCE_ALREADY_EXIST("Resource already exist"),
    INVALID_FORMAT("Invalid format"),
    ACCESS_DENIED("Access denied"),
    ACCESS_FORBIDDEN("Access forbidden"),
    VALIDATION_ERROR("Validation error");

    private String message;

    ErrorCodes(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}

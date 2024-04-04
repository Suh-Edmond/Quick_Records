package com.suh_eddy.quick_records.domain.exception;

import lombok.Data;

@Data
public class BusinessValidationException extends RuntimeException{
    public BusinessValidationException(String message) {
        super(message);
    }
}

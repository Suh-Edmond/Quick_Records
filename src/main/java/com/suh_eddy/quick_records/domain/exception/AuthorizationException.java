package com.suh_eddy.quick_records.domain.exception;

import lombok.Data;

@Data
public class AuthorizationException extends RuntimeException{
    public AuthorizationException(String message) {
        super(message);
    }
}

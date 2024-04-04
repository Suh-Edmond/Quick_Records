package com.suh_eddy.quick_records.domain.exception;

import lombok.Data;

@Data
public class ResourceAlreadyExistException extends RuntimeException{
    public ResourceAlreadyExistException(String message) {
        super(message);
    }
}

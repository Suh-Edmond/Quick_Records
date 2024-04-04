package com.suh_eddy.quick_records.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ErrorResponse {
    private String code;
    private String message;
    private String detail;
    private String path;
    private Date timestamp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ErrorItem> errors = new ArrayList<>();

    public void addError(ErrorItem errorItem){
        this.errors.add(errorItem);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ErrorItem {
        private String field;
        private String message;
    }
}

package com.project.usermanagament.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BusinessException extends RuntimeException {

    private List<ErrorModel> errors;

    public BusinessException(List<ErrorModel> errors){
        this.errors = errors;
    }
}

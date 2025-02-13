package com.project.usermanagement.services.impl;

import com.project.usermanagement.exceptions.BusinessException;
import com.project.usermanagement.exceptions.ErrorModel;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ExceptionService {

    public BusinessException buildNotFoundException(String message) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode("NOT_FOUND");
        errorModel.setMessage(message);

        return new BusinessException(Collections.singletonList(errorModel));
    }
}

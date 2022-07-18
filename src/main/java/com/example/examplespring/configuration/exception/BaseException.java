package com.example.examplespring.configuration.exception;

import com.example.examplespring.configuration.http.BaseResponseCode;

public class BaseException extends AbstractBaseException{

    private static final long serialVersionUID = 4986082337273635493L;

    public BaseException() {
    }

    public BaseException(BaseResponseCode responseCode) {
        this.responseCode = responseCode;
    }
}

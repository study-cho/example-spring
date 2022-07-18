package com.example.examplespring.configuration.exception;

import com.example.examplespring.configuration.http.BaseResponseCode;

public abstract class AbstractBaseException extends RuntimeException{

    private static final long serialVersionUID = 4986082337273635493L;

    protected BaseResponseCode responseCode;
    protected Object[] args;

    public AbstractBaseException() {}

    public AbstractBaseException(BaseResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public BaseResponseCode getResponseCode() {
        return responseCode;
    }

    public Object[] getArgs() {
        return args;
    }
}

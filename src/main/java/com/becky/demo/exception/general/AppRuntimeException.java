package com.becky.demo.exception.general;

import com.becky.demo.exception.constants.ErrorEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class AppRuntimeException extends RuntimeException {
    private ErrorEnum errorEnum;

    public AppRuntimeException() {
        super();
    }


    public AppRuntimeException(ErrorEnum errorEnum, Object... params) {
        super(params.toString());
        this.errorEnum = errorEnum;
    }

    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }

    public void setErrorEnum(ErrorEnum errorEnum) {
        this.errorEnum = errorEnum;
    }
}

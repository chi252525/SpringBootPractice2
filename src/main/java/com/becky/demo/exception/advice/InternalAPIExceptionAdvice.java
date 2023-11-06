package com.becky.demo.exception.advice;

import com.becky.demo.annotation.InternalAPIController;
import com.becky.demo.annotation.PublicAPIController;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = {InternalAPIController.class})
@Order(200)
public class InternalAPIExceptionAdvice extends GlobalExceptionHandler {

    @Override
    protected HttpStatus getHttpStatus(HttpStatus httpStatus) {
        return super.getHttpStatus(httpStatus);
    }

}

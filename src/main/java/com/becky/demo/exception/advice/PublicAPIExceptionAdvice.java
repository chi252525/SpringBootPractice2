package com.becky.demo.exception.advice;

import com.becky.demo.annotation.PublicAPIController;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = {PublicAPIController.class})
@Order(100)
public class PublicAPIExceptionAdvice extends GlobalExceptionHandler {

    @Override
    protected HttpStatus getHttpStatus(HttpStatus httpStatus) {
        return HttpStatus.OK;
    }

}

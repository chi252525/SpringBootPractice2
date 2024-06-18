package com.becky.demo.exception.advice;

import com.becky.demo.model.entity.response.ErrorResponse;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.BindException;
import java.util.Arrays;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    protected HttpStatus getHttpStatus(HttpStatus httpStatus) {
        return (httpStatus == null) ? HttpStatus.INTERNAL_SERVER_ERROR : httpStatus;
    }

    @ExceptionHandler(value = {BadRequestException.class,
            NotFoundException.class})
    public ResponseEntity<ErrorResponse> handleBadRequest(Exception e) {
        HttpStatus status;
        if (e instanceof BadRequestException) {
            status = HttpStatus.BAD_REQUEST;
        } else if (e instanceof NotFoundException) {
            status = HttpStatus.NOT_FOUND;
        } else {
            status = HttpStatus.CONFLICT;
        }
        return getResponse(status, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnknownException(Exception e) {
        return getResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error");
    }

//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public ResponseEntity<ErrorResponse> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
//        return getResponse(HttpStatus.METHOD_NOT_ALLOWED, e.getMessage());
//    }

//Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.web.servlet.HandlerExceptionResolver]: Factory method 'handlerExceptionResolver' threw exception; nested exception is java.lang.IllegalStateException: Ambiguous @ExceptionHandler method mapped for [class org.springframework.http.converter.HttpMessageNotReadableException]: {public org.springframework.http.ResponseEntity com.becky.demo.exception.advice.GlobalExceptionHandler.handleInvalidJson(org.springframework.http.converter.HttpMessageNotReadableException), public final org.springframework.http.ResponseEntity org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler.handleException(java.lang.Exception,org.springframework.web.context.request.WebRequest) throws java.lang.Exception}

//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public ResponseEntity<ErrorResponse> handleInvalidJson(HttpMessageNotReadableException e) {
//        if (e.getRootCause() instanceof BadRequestException) {
//            return getResponse(HttpStatus.BAD_REQUEST, e.getRootCause().getMessage());
//        }
//        return getResponse(HttpStatus.BAD_REQUEST, "Invalid Json in request body");
//    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorResponse> handleInvalidArgumentTypes() {
        return getResponse(HttpStatus.BAD_REQUEST, "Argument types are invalid, please check your request parameters");
    }

    private ResponseEntity<ErrorResponse> getResponse(HttpStatus status, String message) {
        ErrorResponse rsp = new ErrorResponse();
        rsp.setStatus(status.value());
        rsp.setMessage(Arrays.asList(message));
        return ResponseEntity.status(status).body(rsp);
    }
}

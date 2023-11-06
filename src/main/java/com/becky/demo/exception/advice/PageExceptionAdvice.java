package com.becky.demo.exception.advice;

import com.becky.demo.annotation.InternalAPIController;
import com.becky.demo.exception.general.AccessDeniedException;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackages = {"com.becky.demo.controller.page"})
@Order(50)
public class PageExceptionAdvice {
    @ExceptionHandler
    public ModelAndView handleException(HttpServletRequest req, AccessDeniedException e){
        ModelAndView mv = new ModelAndView("accessdenied");
        mv.addObject("message",e.getErrorCode().toString());
        return mv;
    }
}

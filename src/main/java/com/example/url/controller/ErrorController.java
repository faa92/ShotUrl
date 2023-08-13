package com.example.url.controller;

import com.example.url.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@ControllerAdvice
@Slf4j
public class ErrorController {

    @ExceptionHandler(BusinessException.class)
    public ModelAndView onBusinessException (BusinessException e){
        log.warn("Business error: {}", e.toString());
        return new ModelAndView("error-page",
                Map.of("errorMessage", e.getMessage()));
    }
    @ExceptionHandler(Exception.class)
    public ModelAndView onException (Exception e){
        log.error("Unknown error:", e);
        return new ModelAndView("error-page",
                Map.of("errorMessage", "Неизвестная ошибка"));
    }
}

















package com.fonyou.test.shared.infrastructure.spring;

import com.fonyou.test.shared.model.exception.ExceptionCode;
import com.fonyou.test.shared.model.exception.ExceptionResponse;
import com.fonyou.test.shared.model.exception.OperationNotAllowed;
import org.apache.coyote.BadRequestException;
import org.hibernate.query.sqm.PathElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class RestExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(value = {HttpMessageNotReadableException.class, MethodArgumentNotValidException.class, BadRequestException.class, PathElementException.class, MissingServletRequestParameterException.class})
    private ResponseEntity<ExceptionResponse> handleBadRequest(Exception ex) {
        this.logger.error("--RestExceptionHandler:handleBadRequest" + ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ExceptionCode.INVALID_REQUEST, ExceptionCode.INVALID_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {OperationNotAllowed.class})
    private ResponseEntity<ExceptionResponse> handleOperationNotAllowed(Exception ex) {
        this.logger.error("--RestExceptionHandler:handleOperationNotAllowed" + ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ExceptionCode.OPERATION_NOT_ALLOWED, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NoResourceFoundException.class})
    private ResponseEntity<ExceptionResponse> handleNoResourceFound(Exception ex) {
        this.logger.error("--RestExceptionHandler:handleNoResourceFound" + ex.getMessage());
        return new ResponseEntity<>(new ExceptionResponse(ExceptionCode.INVALID_REQUEST, ExceptionCode.INVALID_REQUEST.value()), HttpStatus.NOT_FOUND);
    }
}

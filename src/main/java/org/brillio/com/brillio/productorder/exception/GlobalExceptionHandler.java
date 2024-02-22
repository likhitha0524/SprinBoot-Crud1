package org.brillio.com.brillio.productorder.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionInfo> handleRuntimeException(HttpServletRequest request,
                                                                RuntimeException exception){
        ExceptionInfo exceptionInfo = new ExceptionInfo(request.getRequestURI(), exception.getMessage());
        return new ResponseEntity<>(exceptionInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionInfo> handleNotFoundException(HttpServletRequest request,
                                                                NotFoundException exception){
        ExceptionInfo exceptionInfo = new ExceptionInfo(request.getRequestURI(), exception.getMessage());
        return new ResponseEntity<>(exceptionInfo, HttpStatus.NOT_FOUND);
    }
}

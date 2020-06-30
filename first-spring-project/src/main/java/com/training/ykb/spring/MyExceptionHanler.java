package com.training.ykb.spring;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHanler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MyErrorObject handleEx(final MethodArgumentNotValidException exp) {
        List<ObjectError> allErrorsLoc = exp.getBindingResult()
                                            .getAllErrors();
        MyErrorObject myErr = new MyErrorObject("IT",
                                                "CRM",
                                                "Account",
                                                "Validation Error.");
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            StringBuilder str = new StringBuilder(100);
            str.append("[Error : ");
            str.append(objectErrorLoc.getDefaultMessage());
            str.append("]");
            myErr.addError(new MyErrorObject("IT",
                                             "CRM",
                                             "Account",
                                             str.toString()));
        }
        return myErr;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorObject> handleEx(final Exception exp) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(new MyErrorObject("IT",
                                                     "CRM",
                                                     "Account",
                                                     "Error : " + exp.getMessage()));
    }


}

package com.sherlock.exception;

import com.sherlock.model.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger;

    @ExceptionHandler({IncorrectQuerySyntaxException.class})
    protected ResponseEntity<ResponseObject> handleIncorrectQuerySyntax(RuntimeException exception)
    {
        logger = LoggerFactory.getLogger(ApiExceptionHandler.class.getName());
        return buildInvalidResponseObject();

    }

    private ResponseEntity<ResponseObject> buildInvalidResponseObject()
    {
        ResponseEntity<ResponseObject> responseObjectResponseEntity =
                new ResponseEntity<>(new ResponseObject(), HttpStatus.INTERNAL_SERVER_ERROR);

        return responseObjectResponseEntity;
    }

}

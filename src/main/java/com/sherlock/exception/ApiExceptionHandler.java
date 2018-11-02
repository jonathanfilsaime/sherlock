package com.sherlock.exception;

import com.sherlock.model.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger;

    @ExceptionHandler({IncorrectQuerySyntaxException.class})
    public ResponseEntity<ResponseObject> handleIncorrectQuerySyntax(RuntimeException exception)
    {
        logger = LoggerFactory.getLogger(ApiExceptionHandler.class.getName());
        return buildInvalidResponseObject();

    }

    public ResponseEntity<ResponseObject> buildInvalidResponseObject()
    {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("message", "Incorrect Syntax");
        ResponseEntity<ResponseObject> responseObjectResponseEntity =
                new ResponseEntity<>(new ResponseObject(),map, HttpStatus.BAD_REQUEST);

        return responseObjectResponseEntity;
    }

}

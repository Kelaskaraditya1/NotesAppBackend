package com.StarkIndustries.NotesAppBackend.Exceptions;

import com.StarkIndustries.NotesAppBackend.Keys.Keys;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,Object> property = new LinkedHashMap<>();
        property.put(Keys.TIMESTAMP,System.currentTimeMillis());
        property.put(Keys.STATUS,status);
        List<String> errors = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error->error.getDefaultMessage())
                .toList();
        property.put(Keys.ERROR,errors);
        return new ResponseEntity<Object>(property,status);
    }
}

package com.sd61.urbankicks.exceptions;

import com.sd61.urbankicks.responses.ResponseData;
import com.sd61.urbankicks.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseData<?>> handleValidationException(
            MethodArgumentNotValidException ex
    ) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(err -> errors.put(toSnakeCase(err.getField()), err.getDefaultMessage()));

        return ResponseUtil.error(
                "Validation failed",
                HttpStatus.BAD_REQUEST,
                errors
        );
    }
    private String toSnakeCase(String input) {
        return input.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
    }
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ResponseData<?>> handleNotFound(
            DataNotFoundException ex
    ) {
        return ResponseUtil.error(
                ex.getMessage(),
                HttpStatus.NOT_FOUND,
                null
        );
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ResponseData<?>> handleNotFound(
            DuplicateResourceException ex
    ) {
        return ResponseUtil.error(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                null
        );
    }
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ResponseData<?>> handleBusinessValidation(
            ValidationException ex
    ) {
        return ResponseUtil.error(
                "Validation failed",
                HttpStatus.BAD_REQUEST,
                ex.getErrors()
        );
    }

}

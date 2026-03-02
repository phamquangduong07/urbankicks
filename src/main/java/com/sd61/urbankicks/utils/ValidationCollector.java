package com.sd61.urbankicks.utils;

import com.sd61.urbankicks.exceptions.ValidationException;

import java.util.HashMap;
import java.util.Map;

public class ValidationCollector {

    private final Map<String, String> errors = new HashMap<>();

    public ValidationCollector check(boolean condition, String field, String message) {
        if (condition) {
            errors.put(field, message);
        }
        return this;
    }

    public void validate() {
        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
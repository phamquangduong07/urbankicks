package com.sd61.urbankicks.utils;

import com.sd61.urbankicks.responses.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ResponseUtil{
    public static <T> ResponseEntity<ResponseData<T>> success(
            T data,
            String message,
            HttpStatus status
    ) {
        ResponseData<T> body = ResponseData.<T>builder()
                .success(true)
                .message(message)
                .status(status.value())
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(body, status);
    }

    public static ResponseEntity<ResponseData<?>> error(
            String message,
            HttpStatus status,
            Object data
    ) {
        ResponseData<?> body = ResponseData.builder()
                .success(false)
                .message(message)
                .status(status.value())
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(body, status);
    }
}

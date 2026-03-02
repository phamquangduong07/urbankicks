package com.sd61.urbankicks.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseData<T> {
    private boolean success;
    private String message;
    private int status;
    private T data;
    private LocalDateTime timestamp;
}

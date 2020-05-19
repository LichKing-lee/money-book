package com.yong.moneybookweb.common.exception.handler;

import java.util.Objects;
import com.yong.moneybookweb.common.exception.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class MoneyBookExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handle(MethodArgumentNotValidException e) {
        var result = new ApiErrorResult(ErrorCode.INVALID_PARAMETER, e.getBindingResult().getFieldError().getDefaultMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(result);
    }

    @Data
    @AllArgsConstructor
    static class ApiErrorResult {
        private ErrorCode code;
        private String message;

        public ApiErrorResult(ErrorCode code) {
            this(code, code.getDefaultMessage());
        }
    }
}

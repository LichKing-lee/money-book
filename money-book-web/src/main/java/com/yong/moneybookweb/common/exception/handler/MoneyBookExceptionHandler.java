package com.yong.moneybookweb.common.exception.handler;

import com.yong.moneybookweb.common.exception.ErrorCode;
import com.yong.moneybookweb.common.exception.MoneyBookException;
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
    public ResponseEntity<?> methodArgumentNotValidExceptionHandle(MethodArgumentNotValidException e) {
        ErrorCode errorCode = ErrorCode.INVALID_PARAMETER;
        var result = new ApiErrorResult(errorCode,
                e.getBindingResult().getFieldError().getDefaultMessage());

        return ResponseEntity.status(errorCode.getStatus())
                .body(result);
    }

    @ExceptionHandler(MoneyBookException.class)
    public ResponseEntity<?> moneyBookExceptionHandle(MoneyBookException e) {
        if(e.getLogMessage() != null) {
            log.error(e.getLogMessage());
        } else {
            log.error("Occurred exception", e);
        }

        var result = new ApiErrorResult(e.getErrorCode(), e.getMessage());

        return ResponseEntity.status(e.getErrorCode().getStatus())
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

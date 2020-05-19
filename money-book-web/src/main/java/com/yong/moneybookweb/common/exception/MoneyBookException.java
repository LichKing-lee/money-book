package com.yong.moneybookweb.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MoneyBookException extends RuntimeException {
    private ErrorCode errorCode;
    private String message;
    private String logMessage;

    public MoneyBookException(ErrorCode errorCode) {
        this(errorCode, errorCode.getDefaultMessage());
    }

    public MoneyBookException(String message) {
        this(ErrorCode.SERVER_ERROR, message);
    }

    public MoneyBookException(ErrorCode errorCode, String message) {
        this(errorCode, message, null);
    }
}

package com.yong.moneybookweb.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_PARAMETER("요청 파라미터가 잘못되었습니다.");

    private final String defaultMessage;
}

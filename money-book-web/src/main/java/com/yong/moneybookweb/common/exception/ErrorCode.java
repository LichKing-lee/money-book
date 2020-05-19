package com.yong.moneybookweb.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    SERVER_ERROR("서버 에러가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_PARAMETER("요청 파라미터가 잘못되었습니다.", HttpStatus.BAD_REQUEST),
    EXISTS_EMAIL("존재하는 email 입니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    MEMBER_NOTFOUND("유저가 존재하지않습니다.", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String defaultMessage;
    private final HttpStatus status;
}

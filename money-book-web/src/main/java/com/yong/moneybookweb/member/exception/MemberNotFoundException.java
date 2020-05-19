package com.yong.moneybookweb.member.exception;

import com.yong.moneybookweb.common.exception.ErrorCode;
import com.yong.moneybookweb.common.exception.MoneyBookException;

public class MemberNotFoundException extends MoneyBookException {
    public MemberNotFoundException(Long memberId) {
        super(ErrorCode.MEMBER_NOTFOUND, ErrorCode.MEMBER_NOTFOUND.getDefaultMessage(),
                String.format("Not found member :: %s", memberId));
    }
}

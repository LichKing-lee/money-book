package com.yong.moneybookweb.member.exception;

import com.yong.moneybookweb.common.exception.ErrorCode;
import com.yong.moneybookweb.common.exception.MoneyBookException;

public class MemberDuplicatedException extends MoneyBookException {
    public MemberDuplicatedException(String email) {
        super(ErrorCode.EXISTS_EMAIL, ErrorCode.EXISTS_EMAIL.getDefaultMessage(),
                String.format("Exists email :: %s", email));
    }
}

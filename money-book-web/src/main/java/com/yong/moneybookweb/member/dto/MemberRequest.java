package com.yong.moneybookweb.member.dto;

import javax.validation.constraints.NotEmpty;
import com.yong.moneybookweb.member.Member;
import lombok.Data;

@Data
public class MemberRequest {
    @NotEmpty(message = "name is required field")
    private String name;
    @NotEmpty(message = "email is required field")
    private String email;
    @NotEmpty(message = "password is required field")
    private String password;

    public Member toMember() {
        return new Member(name, email, password);
    }
}

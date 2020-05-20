package com.yong.moneybookweb.member.dto;

import javax.validation.constraints.NotEmpty;
import com.yong.moneybookweb.member.entity.Member;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    public void encodePassword(PasswordEncoder passwordEncoder) {
        password = passwordEncoder.encode(password);
    }
}

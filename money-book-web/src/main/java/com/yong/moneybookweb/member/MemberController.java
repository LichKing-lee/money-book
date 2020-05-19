package com.yong.moneybookweb.member;

import javax.validation.Valid;
import com.yong.moneybookweb.member.dto.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members/sign-up")
    public String join(@Valid @RequestBody MemberRequest request) {
        memberService.signup(request.toMember());
        return "hello member";
    }
}

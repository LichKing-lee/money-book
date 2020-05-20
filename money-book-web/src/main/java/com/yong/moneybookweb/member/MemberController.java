package com.yong.moneybookweb.member;

import javax.validation.Valid;
import com.yong.moneybookweb.member.dto.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/sign-up")
    public String signup() {
        return "member/signup";
    }

    @PostMapping("/members/sign-up")
    public String join(@Valid @RequestBody MemberRequest request) {
        memberService.signup(request.toMember());
        return "redirect:";
    }
}

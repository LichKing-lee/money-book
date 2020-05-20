package com.yong.moneybookweb.member;

import javax.validation.Valid;
import com.yong.moneybookweb.member.dto.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/members/sign-up")
    public String signup(Model model) {
        model.addAttribute("member", new MemberRequest());
        return "member/signup";
    }

    @ResponseBody
    @PostMapping("/members/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void join(@Valid @RequestBody MemberRequest request) {
        request.encodePassword(passwordEncoder);
        memberService.signup(request.toMember());
    }
}

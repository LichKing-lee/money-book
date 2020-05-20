package com.yong.moneybookweb.member;

import javax.validation.Valid;
import com.yong.moneybookweb.member.dto.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/sign-up")
    public String signup(Model model) {
        model.addAttribute("member", new Member());
        return "member/signup";
    }

    @ResponseBody
    @PostMapping("/members/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public void join(@Valid @RequestBody MemberRequest request) {
        memberService.signup(request.toMember());
    }
}

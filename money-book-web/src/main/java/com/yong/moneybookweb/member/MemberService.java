package com.yong.moneybookweb.member;

import java.util.Optional;
import com.yong.moneybookweb.member.exception.MemberDuplicatedException;
import com.yong.moneybookweb.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public void signup(Member member) {
        Optional<Member> find = memberRepository.findByEmail(member.getEmail());
        if(find.isPresent()) {
            throw new MemberDuplicatedException(member.getEmail());
        }

        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundException(memberId));
    }
}

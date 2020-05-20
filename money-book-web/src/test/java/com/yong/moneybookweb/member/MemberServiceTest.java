package com.yong.moneybookweb.member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.yong.moneybookweb.member.dto.MemberRequest;
import com.yong.moneybookweb.member.entity.Member;
import com.yong.moneybookweb.member.exception.MemberDuplicatedException;
import com.yong.moneybookweb.member.exception.MemberNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class MemberServiceTest {
    @Autowired
    private MemberService memberService;
    @PersistenceContext
    private EntityManager em;

    @Test
    @Transactional
    void 회원가입() throws Exception {
        // given
        MemberRequest request = new MemberRequest();
        request.setName("changyong");
        request.setEmail("abc@abc.abc");
        request.setPassword("123456");

        // when
        Member member = request.toMember();
        memberService.signup(member);

        em.flush();
        em.clear();

        // then
        Member save = memberService.findMember(member.getId());

        assertThat(save.getEmail()).isEqualTo(save.getEmail());
        assertThat(save.getName()).isEqualTo(save.getName());
        assertThat(save.getRole()).isEqualTo(save.getRole());
    }

    @Test
    @Transactional
    void 이메일_중복() throws Exception {
        // given
        회원가입();

        MemberRequest request = new MemberRequest();
        request.setName("changyong");
        request.setEmail("abc@abc.abc");
        request.setPassword("123456");

        // when

        // then
        assertThatThrownBy(() -> memberService.signup(request.toMember()))
                .isInstanceOf(MemberDuplicatedException.class);
    }

    @Test
    void 존재하지않는회원탐색시_예외발생() throws Exception {
        // given

        // when

        // then
        assertThatThrownBy(() -> memberService.findMember(100L))
                .isInstanceOf(MemberNotFoundException.class);
    }
}
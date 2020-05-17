package com.yong.moneybookweb.member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;
    @PersistenceContext
    private EntityManager em;

    @Test
    @Transactional
    void save() throws Exception {
        // given
        Member member = new Member("changyong", "naver@naver.com", "123456");
        // when
        memberRepository.save(member);

        em.flush();
        em.clear();

        Member find = memberRepository.findById(member.getId()).get();

        // then
        assertThat(find.getCreateAt()).isNotNull();
        assertThat(find.getLastModifiedAt()).isNotNull();
    }
}
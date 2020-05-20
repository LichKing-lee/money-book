package com.yong.moneybookweb.member;

import java.util.Optional;
import com.yong.moneybookweb.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}

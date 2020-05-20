package com.yong.moneybookweb.member;

import java.util.HashSet;
import java.util.Set;
import com.yong.moneybookweb.member.entity.Member;
import com.yong.moneybookweb.member.entity.MemberRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberService.findMember(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if(member.getRole() == MemberRole.MEMBER) {
            grantedAuthorities.add(new SimpleGrantedAuthority(MemberRole.MEMBER.name()));
        } else {
            grantedAuthorities.add(new SimpleGrantedAuthority(MemberRole.ADMIN.name()));
        }

        return new User(member.getEmail(), member.getPassword(), grantedAuthorities);
    }
}

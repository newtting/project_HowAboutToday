package com.phoenix.howabouttoday.member.Service;

import com.phoenix.howabouttoday.member.dto.MemberDTO;
import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public Long join(com.phoenix.howabouttoday.member.dto.MemberDTO memberDTO) {
        memberDTO.setPwd(encoder.encode(memberDTO.getPwd()));

        return memberRepository.save(memberDTO.toEntity()).getMemberNum();
    }

    public MemberDTO getCustomer(Long memberNum) throws UsernameNotFoundException {

        Member member = memberRepository.findById(memberNum).get();

        MemberDTO customer = MemberDTO.builder()
                .num(member.getMemberNum())
                .email(member.getEmail())
                .nickname(member.getNickname())
                .memberTel(member.getMemberTel())
                .memberCode(member.getMemberCode())
                .build();

        return customer;
    }
}

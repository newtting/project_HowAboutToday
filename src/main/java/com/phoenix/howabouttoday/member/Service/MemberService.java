package com.phoenix.howabouttoday.member.Service;

import com.phoenix.howabouttoday.member.dto.MemberDTO;
import com.phoenix.howabouttoday.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public Long join(MemberDTO memberDTO) {
        memberDTO.setPwd(encoder.encode(memberDTO.getPwd()));

        return memberRepository.save(memberDTO.toEntity()).getMemberNum();

    }

}

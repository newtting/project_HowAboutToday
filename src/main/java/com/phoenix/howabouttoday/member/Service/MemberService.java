package com.phoenix.howabouttoday.member.Service;

import com.phoenix.howabouttoday.member.dto.MemberDTO;
import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@Service
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public Long join(MemberDTO DTO) {
        DTO.setPwd(encoder.encode(DTO.getPwd()));
        return memberRepository.save(DTO.toEntity()).getMemberNum();
    }
    /* 회원가입 시, 유효성 체크 */
    @Transactional(readOnly = true)
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        //유효성 검사에 실패한 필드 목록을 받음
        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }

    /* 회원수정 (dirty checking) */
    @Transactional
    public void modify(MemberDTO memberDTO) {
        Member member = memberRepository.findById(memberDTO.toEntity().getMemberNum()).orElseThrow(() ->
                new IllegalArgumentException("해당 회원이 존재하지 않습니다."));

        String encPassword = encoder.encode(memberDTO.getPwd());
        member.modify(memberDTO.getNickname(),memberDTO.getMemberTel(), encPassword);
    }



    public MemberDTO getSessionUser(Long memberNum){
        Member member = memberRepository.findById(memberNum).get();

        return MemberDTO.builder()
                .num(member.getMemberNum())
                .email(member.getEmail())
                .pwd(member.getPwd())
                .nickname(member.getNickname())
                .memberTel(member.getMemberTel())
                .role(member.getRole())
                .build();
    }

    public MemberDTO getAuthUser(String email){

        Member member = memberRepository.findByEmail(email).get();

        return MemberDTO.builder()
                .num(member.getMemberNum())
                .email(member.getEmail())
                .pwd(member.getPwd())
                .nickname(member.getNickname())
                .memberTel(member.getMemberTel())
                .role(member.getRole())
                .build();
    }

    public MemberDTO getCustomer(Long memberNum) throws UsernameNotFoundException {

        Member member = memberRepository.findById(memberNum).get();

        MemberDTO customer = MemberDTO.builder()
                .num(member.getMemberNum())
                .email(member.getEmail())
                .nickname(member.getNickname())
                .memberTel(member.getMemberTel())
                .role(member.getRole())
                .build();

        return customer;
    }
}

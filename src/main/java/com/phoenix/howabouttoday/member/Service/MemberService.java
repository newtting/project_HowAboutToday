package com.phoenix.howabouttoday.member.Service;

import com.phoenix.howabouttoday.member.dto.MemberDTO;
import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.member.repository.MemberRepository;
import com.phoenix.howabouttoday.payment.dto.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public Long join(MemberDTO DTO) {
        DTO.setPwd(encoder.encode(DTO.getPwd()));

        return memberRepository.save(DTO.toEntity()).getMemberNum();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> findMember = memberRepository.findByEmail(member.getEmail());
        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    public Customer getCustomer(Long memberNum) throws UsernameNotFoundException {

        Member member = memberRepository.findById(memberNum).get();

        Customer customer = Customer.builder()
                .num(member.getMemberNum())
                .email(member.getEmail())
                .name(member.getNickname())
                .tel(member.getMemberTel())
                .code(member.getMemberCode())
                .orders(member.getOrders())
                .build();

        return customer;
    }
}

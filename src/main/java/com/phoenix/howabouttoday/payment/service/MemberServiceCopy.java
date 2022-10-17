package com.phoenix.howabouttoday.payment.service;

import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.member.repository.MemberRepository;
import com.phoenix.howabouttoday.payment.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceCopy implements UserDetailsService {


    MemberRepository memberRepository;

    public MemberServiceCopy(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Customer getCustomer(Long memberNum) throws UsernameNotFoundException{

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

    public Member getMember(Long memberNum) throws UsernameNotFoundException{
        return memberRepository.findById(memberNum).get();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("실행?");
        return null;
    }
}

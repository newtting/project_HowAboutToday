package com.phoenix.howabouttoday.payment.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService {


    private final MemberRepository memberRepository;
//    private final AccommodationImageRepository accommodationImageRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
//        this.accommodationImageRepository = accommodationImageRepository;
    }


}

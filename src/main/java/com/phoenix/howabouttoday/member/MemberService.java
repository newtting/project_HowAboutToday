package com.phoenix.howabouttoday.member;

import com.phoenix.howabouttoday.member.repository.MemberRepository;
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

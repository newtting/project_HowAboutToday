package com.phoenix.howabouttoday.payment.service;

import com.phoenix.howabouttoday.payment.entity.Accommodation;
import com.phoenix.howabouttoday.payment.repository.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//오버라이딩 된 생성자를 쓰기 위해서 필요한 어노테이션
@RequiredArgsConstructor
@Service
public class AccomodationService {

    private final AccommodationRepository accommodationRepository;


    public void getQuestion() {

        Accommodation acco =  accommodationRepository.findByAccomnum(1L);
        List<Accommodation> accoList = accommodationRepository.findAll();

        for(Accommodation accom: accoList) {
            System.out.println(accom.toString());

        }
        
//        System.out.println(acco.toString());
    }
}

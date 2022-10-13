package com.phoenix.howabouttoday.accom.service;

import com.phoenix.howabouttoday.accom.entity.Accommodation;
import com.phoenix.howabouttoday.accom.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class AccomodationService {
    private final AccommodationRepository accommodationRepository;
//    private final AccommodationImageRepository accommodationImageRepository;

    @Autowired
    public AccomodationService(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
//        this.accommodationImageRepository = accommodationImageRepository;
    }

    @Transactional
    public void createAccom() {

    }

    /*
    리스트 목록 조회
     */
    @Transactional
    public List<Accommodation> getAccommodationlist() {

        return accommodationRepository.findAll();
    }

}

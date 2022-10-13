package com.phoenix.howabouttoday.room.service;

import com.phoenix.howabouttoday.accom.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final AccommodationRepository accommodationRepository;

    @Autowired
    public RoomService(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }



}

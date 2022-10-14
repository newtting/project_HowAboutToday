package com.phoenix.howabouttoday.accom.service;

import com.phoenix.howabouttoday.accom.dto.FaciltiesDTO;
import com.phoenix.howabouttoday.accom.repository.FaciltiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaciltiesService {

    private final FaciltiesRepository faciltiesRepository;

    @Transactional
    public List<FaciltiesDTO> findByAll() {
        return FaciltiesRepository.findByAll();
    }
}

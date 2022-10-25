package com.phoenix.howabouttoday.board.service;

import com.phoenix.howabouttoday.board.dto.EventImageDTO;
import com.phoenix.howabouttoday.board.repository.EventImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class EventImageServiceImpl implements EventImageService{

    // Image : Event

    private final EventImageRepository eventImageRepository;

    // 이미지 리스트 (모든 이미지 조회)
    @Override
    public List<EventImageDTO> findAll_Image(Long eventNum) {

        return eventImageRepository.findByEventImageNum(eventNum)
                .stream()
                .map(EventImageDTO::new)
                .collect(Collectors.toList());
    }

}

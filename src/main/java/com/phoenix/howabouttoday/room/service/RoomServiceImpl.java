package com.phoenix.howabouttoday.room.service;

import com.phoenix.howabouttoday.room.dto.RoomDTO;
import com.phoenix.howabouttoday.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;

    // 객실 리스트
    @Override
    public List<RoomDTO> findAll() {

        List<RoomDTO> lists = roomRepository.findAll()
                .stream()
                .map(RoomDTO::new)
                .collect(Collectors.toList());

        return lists;

    }
    // 객실 상세
    @Override
    public RoomDTO findOne(Long roomNum) {
        return null;
    }

}

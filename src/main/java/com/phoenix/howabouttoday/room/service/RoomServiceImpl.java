package com.phoenix.howabouttoday.room.service;

import com.phoenix.howabouttoday.room.dto.RoomListDTO;
import com.phoenix.howabouttoday.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;

    //객실 리스트
    @Override
    public List<RoomListDTO> findAll_Room() {

        List<RoomListDTO> lists = roomRepository.findAll()
                .stream()
                .map(RoomListDTO::new)
                .collect(Collectors.toList());

        return lists;
    }


}

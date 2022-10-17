package com.phoenix.howabouttoday.room.service;

import com.phoenix.howabouttoday.room.dto.RoomDTO;
import com.phoenix.howabouttoday.room.entity.Room;
import com.phoenix.howabouttoday.room.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoomService {

    //객실 리스트 처리
    List<RoomDTO> findAll();

    //객실 상세 페이지 처리
    RoomDTO findOne(Long roomNum);

}

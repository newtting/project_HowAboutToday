package com.phoenix.howabouttoday.room.service;

import com.phoenix.howabouttoday.room.dto.RoomAmenitiesDTO;
import com.phoenix.howabouttoday.room.dto.RoomListDTO;
import com.phoenix.howabouttoday.room.dto.RoomServiceDTO;

import java.util.List;

public interface RoomService {
    List<RoomListDTO> findAll_Room(Long accomNum); //객실 리스트

    List<RoomAmenitiesDTO> findAll_Amenities(Long roomNum); //객실 디테일 - 시설 리스트

    List<RoomServiceDTO> findAll_Service(Long roomNum); //객실 디테일 - 서비스 리스트

    //객실 디테일

}
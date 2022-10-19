package com.phoenix.howabouttoday.room.service;

import com.phoenix.howabouttoday.room.dto.RoomListDTO;

import java.util.List;

public interface RoomService {

    List<RoomListDTO> findAll_Room();

}
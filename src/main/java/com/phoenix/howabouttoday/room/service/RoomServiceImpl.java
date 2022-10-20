package com.phoenix.howabouttoday.room.service;

import com.phoenix.howabouttoday.room.dto.RoomAmenitiesDTO;
import com.phoenix.howabouttoday.room.dto.RoomListDTO;
import com.phoenix.howabouttoday.room.dto.RoomServiceDTO;
import com.phoenix.howabouttoday.room.repository.RoomRepository;
import com.phoenix.howabouttoday.room.repository.RoomViewAmenitiesRepository;
import com.phoenix.howabouttoday.room.repository.RoomViewServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
@Repository
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;
    private final RoomViewAmenitiesRepository roomViewAmenitiesRepository;
    private final RoomViewServiceRepository roomViewServiceRepository;

    //객실 리스트
    @Override
    public List<RoomListDTO> findAll_Room(Long accomNum) {

        List<RoomListDTO> lists = roomRepository.findAllByAccommodationAccomNum(accomNum)
                .stream()
                .map(RoomListDTO::new)
                .collect(Collectors.toList());

        return lists;
    }

    // 시설 리스트
    @Override
    public List<RoomAmenitiesDTO> findAll_Amenities(Long roomNum) {

        List<RoomAmenitiesDTO> alist = roomViewAmenitiesRepository.findAllByAmenitiesRoomNum(roomNum)
                .stream()
                .map(RoomAmenitiesDTO::new)
                .collect(Collectors.toList());

        return alist;

    }

    @Override
    public List<RoomServiceDTO> findAll_Service(Long roomNum) {

        List<RoomServiceDTO> slist = roomViewServiceRepository.findAllByServiceRoomNum(roomNum)
                .stream()
                .map(RoomServiceDTO::new)
                .collect(Collectors.toList());

        return slist;

    }

    //객실 디테일

}

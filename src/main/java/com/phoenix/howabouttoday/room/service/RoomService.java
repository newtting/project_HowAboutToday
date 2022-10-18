package com.phoenix.howabouttoday.room.service;

import com.phoenix.howabouttoday.room.dto.RoomDTO;
import com.phoenix.howabouttoday.room.entity.Room;
import com.phoenix.howabouttoday.room.entity.RoomImage;
import com.phoenix.howabouttoday.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    //객실 리스트 처리
    public List<Room> getRoomList() {
        return roomRepository.findAll();
    }

    public void saveData(){
        roomRepository.save(createRoom());
    }

    public Room createRoom() {

        Room room = Room.builder()
                .roomName("스위트룸")
                .defaultGuest(2)
                .maxGuest(4)
                .stayStartDate(LocalDate.of(2022,11,22))
                .stayEndDate(LocalDate.of(2022,11,25))
                .price(80000)
                .roomInfo("객실 정보")
                .build();

        RoomImage image = RoomImage.builder()
                .roomOriginFileName("image.jpg")
                .roomSaveFileName("image.jpg")
                .room(room)
                .build();

        return room;

    }

    public RoomDTO convertEntityToDto(Room room) {

        return RoomDTO.builder()
                .roomName(room.getRoomName())
                .defaultGuest(room.getDefaultGuest())
                .maxGuest(room.getMaxGuest())
                .price(room.getPrice())
                .roomInfo(room.getRoomInfo())
                .stayStartDate(room.getStayStartDate())
                .stayEndDate(room.getStayEndDate())
                .price(room.getPrice())
                .build();

    }

}

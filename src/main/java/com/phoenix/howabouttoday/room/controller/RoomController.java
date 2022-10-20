package com.phoenix.howabouttoday.room.controller;

import com.phoenix.howabouttoday.room.dto.RoomAmenitiesDTO;
import com.phoenix.howabouttoday.room.dto.RoomListDTO;
import com.phoenix.howabouttoday.room.dto.RoomServiceDTO;
import com.phoenix.howabouttoday.room.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("room-details")
    public String getRoomDetails(Model model, Long roomNum){

        List<RoomAmenitiesDTO> aList = roomService.findAll_Amenities(roomNum);
        model.addAttribute("alist",aList);

        List<RoomServiceDTO> sList = roomService.findAll_Service(roomNum);
        model.addAttribute("slist",aList);

        return "accom/room/room-details";

    }
    @PostMapping("room-details")
    public String postRoomDetails(){
        return "accom/room/room-details";
    }

}

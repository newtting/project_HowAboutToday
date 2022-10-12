package com.phoenix.howabouttoday.room.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RoomController {

    @GetMapping("room-details")
    public String getRoomDetails(){
        return "accom/room/room-details";
    }
    @PostMapping("room-details")
    public String postRoomDetails(){
        return "accom/room/room-details";
    }

}

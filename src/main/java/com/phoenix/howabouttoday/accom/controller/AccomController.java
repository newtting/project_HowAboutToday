package com.phoenix.howabouttoday.accom.controller;

import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AccomController {

    // 메인 화면
    @GetMapping("home")
    public String getIndex2(){
        return "home";
    }
    @PostMapping("home")
    public String postIndex2(){
        return "home";
    }

    @GetMapping("add-hotel")
    public String getAddHotel(){
        return "accom/hotel/add-hotel";
    }
    @PostMapping("add-hotel")
    public String postAddHotel(){
        return "accom/hotel/add-hotel";
    }

    @GetMapping("hotel-grid")
    public String getHotelGrid(){
        return "accom/hotel/hotel-grid";
    }
    @PostMapping("hotel-grid")
    public String postHotelGrid(){
        return "accom/hotel/hotel-grid";
    }

    @GetMapping("hotel-list")
    public String getHotelList(){
        return "accom/hotel/hotel-list";
    }
    @PostMapping("hotel-list")
    public String postHotelList(){
        return "accom/hotel/hotel-list";
    }

    @GetMapping("hotel-search-result")
    public String getHotelSearchResult(){
        return "accom/hotel/hotel-search-result";
    }
    @PostMapping("hotel-search-result")
    public String postHotelSearchResult(){
        return "accom/hotel/hotel-search-result";
    }

    @GetMapping("hotel-sidebar")
    public String getHotelSidebar(){
        return "accom/hotel/hotel-sidebar";
    }
    @PostMapping("hotel-sidebar")
    public String postHotelSidebar(){
        return "accom/hotel/hotel-sidebar";
    }

    @GetMapping("hotel-single")
    public String getHotelSingle(){
        return "accom/hotel/hotel-single";
    }
    @PostMapping("hotel-single")
    public String postHotelSingle(){
        return "accom/hotel/hotel-single";
    }

    @GetMapping("room-details")
    public String getRoomDetails(){
        return "accom/room/room-details";
    }
    @PostMapping("room-details")
    public String postRoomDetails(){
        return "accom/room/room-details";
    }

    @GetMapping("room-grid")
    public String getRoomGird(){
        return "accom/room/room-grid";
    }
    @PostMapping("room-grid")
    public String postRoomGird(){
        return "accom/room/room-grid";
    }

    @GetMapping("room-list")
    public String getRoomList(){
        return "accom/room/room-list";
    }
    @PostMapping("room-list")
    public String postRoomList(){
        return "accom/room/room-list";
    }

    @GetMapping("room-search-result")
    public String getRoomSearchResult(){
        return "accom/room/room-search-result";
    }
    @PostMapping("room-search-result")
    public String postRoomSearchResult(){
        return "accom/room/room-search-result";
    }

    @GetMapping("room-search-result-list")
    public String getRoomSearchResultList(){
        return "accom/room/room-search-result-list";
    }
    @PostMapping("room-search-result-list")
    public String postRoomSearchResultList(){
        return "accom/room/room-search-result-list";
    }

}

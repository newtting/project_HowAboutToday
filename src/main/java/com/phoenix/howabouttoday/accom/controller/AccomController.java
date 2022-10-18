package com.phoenix.howabouttoday.accom.controller;

import com.phoenix.howabouttoday.accom.service.AccomodationService;
import com.phoenix.howabouttoday.room.dto.RoomDTO;
import com.phoenix.howabouttoday.room.entity.Room;
import com.phoenix.howabouttoday.room.service.RoomService;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AccomController {

    private final AccomodationService accommodationService;
    private final RoomService roomService;

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

    //호텔 상세페이지 - 객실리스트
    @GetMapping("hotel-single")
    public String getHotelSingle(Model model){

        List<Room> roomList = roomService.getRoomList();
        model.addAttribute("roomlist",roomList);

        return "accom/hotel/hotel-single";

    }
    @PostMapping("hotel-single")
    public String postHotelSingle(){return "accom/hotel/hotel-single";}

    @GetMapping("motel-list")
    public String getMotelList(){
        return "accom/hotel/motel-list";
    }
    @PostMapping("motel-list")
    public String postMotelList(){
        return "accom/hotel/motel-list";
    }

    @GetMapping("motel-search-result")
    public String getMotelSearchResult(){
        return "accom/hotel/motel-search-result";
    }
    @PostMapping("motel-search-result")
    public String postMotelSearchResult(){
        return "accom/hotel/motel-search-result";
    }

    //모텔 상세페이지 - 객실리스트
    @GetMapping("motel-single")
    public String getMotelSingle(Model model){

        List<Room> roomList = roomService.getRoomList();
        model.addAttribute("roomlist",roomList);

        return "accom/hotel/motel-single";

    }
    @PostMapping("motel-single")
    public String postMotelSingle(){
        return "accom/hotel/motel-single";
    }

    @GetMapping("pension-PoolVilla-list")
    public String getPensionPoolVillaList(){
        return "accom/hotel/pension-PoolVilla-list";
    }
    @PostMapping("pension-PoolVilla-list")
    public String postPensionPoolVillaList(){
        return "accom/hotel/pension-PoolVilla-list";
    }

    //펜션/풀빌라 상세페이지 - 객실리스트
    @GetMapping("pension-PoolVilla-single")
    public String getPensionPoolVillaSingle(Model model){

        List<Room> roomList = roomService.getRoomList();
        model.addAttribute("roomlist",roomList);

        return "accom/hotel/pension-PoolVilla-single";

    }
    @PostMapping("pension-PoolVilla-single")
    public String postPensionPoolVillaSingle(){
        return "accom/hotel/pension-PoolVilla-single";
    }

    @GetMapping("pension-PoolVilla-result")
    public String getPensionPoolVillaResult(){
        return "accom/hotel/pension-PoolVilla-result";
    }
    @PostMapping("pension-PoolVilla-result")
    public String postPensionPoolVillaResult(){
        return "accom/hotel/pension-PoolVilla-result";
    }

    @GetMapping("guestHouse-Hanok-list")
    public String getGuestHouseList(){ return "accom/hotel/guestHouse-Hanok-list";}
    @PostMapping("guestHouse-Hanok-list")
    public String postGuestHouseList(){ return "accom/hotel/guestHouse-Hanok-list";}

    @GetMapping("guestHouse-Hanok-result")
    public String getGuestHouseSingle(){ return "accom/hotel/guestHouse-Hanok-result";}
    @PostMapping("guesthouse-Hanok-result")
    public String postGuestHouseSingle(){ return "accom/hotel/guestHouse-Hanok-result";}

    //게하/한옥 상세페이지 - 객실리스트
    @GetMapping("guestHouse-Hanok-single")
    public String getGuestHouseResult(Model model){

        List<Room> roomList = roomService.getRoomList();
        model.addAttribute("roomlist",roomList);

        return "accom/hotel/guestHouse-Hanok-single";

    }
    @PostMapping("guestHouse-Hanok-single")
    public String postGuestHouseResult(){ return "accom/hotel/guestHouse-Hanok-single";}


}

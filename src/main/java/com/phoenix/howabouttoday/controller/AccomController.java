package com.phoenix.howabouttoday.controller;

import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AccomController {

    @GetMapping("home")
    public String getIndex2(){
        return "index2";
    }
    @PostMapping("home")
    public String postIndex2(){
        return "index2";
    }

    @GetMapping("add-hotel")
    public String getAddHotel(){
        return "add-hotel";
    }
    @PostMapping("add-hotel")
    public String postAddHotel(){
        return "add-hotel";
    }

    @GetMapping("cart")
    public String getCart(){
        return "cart";
    }
    @PostMapping("cart")

    public String postCart(){
        return "cart";
    }

    @GetMapping("checkout")
    public String getCheckout(){
        return "checkout";
    }
    @PostMapping("checkout")
    public String postCheckout(){
        return "checkout";
    }

    @GetMapping("hotel-booking")
    public String getHotelBooking(){
        return "hotel-booking";
    }
    @PostMapping("hotel-booking")
    public String postHotelBooking(){
        return "hotel-booking";
    }

    @GetMapping("hotel-grid")
    public String getHotelGrid(){
        return "hotel-grid";
    }
    @PostMapping("hotel-grid")
    public String postHotelGrid(){
        return "hotel-grid";
    }

    @GetMapping("hotel-list")
    public String getHotelList(){
        return "hotel-list";
    }
    @PostMapping("hotel-list")
    public String postHotelList(){
        return "hotel-list";
    }

    @GetMapping("hotel-search-result")
    public String getHotelSearchResult(){
        return "hotel-search-result";
    }
    @PostMapping("hotel-search-result")
    public String postHotelSearchResult(){
        return "hotel-search-result";
    }

    @GetMapping("hotel-sidebar")
    public String getHotelSidebar(){
        return "hotel-sidebar";
    }
    @PostMapping("hotel-sidebar")
    public String postHotelSidebar(){
        return "hotel-sidebar";
    }

    @GetMapping("hotel-single")
    public String getHotelSingle(){
        return "hotel-single";
    }
    @PostMapping("hotel-single")
    public String postHotelSingle(){
        return "hotel-single";
    }

    @GetMapping("payment-complete")
    public String getPaymentComplete(){
        return "payment-complete";
    }
    @PostMapping("payment-complete")
    public String postPaymentComplete(){
        return "payment-complete";
    }

    @GetMapping("payment-received")
    public String getPaymentReceived(){
        return "payment-received";
    }
    @PostMapping("payment-received")
    public String postPaymentReceived(){
        return "payment-received";
    }

    @GetMapping("recover")
    public String getRecover(){
        return "recover";
    }
    @PostMapping("recover")
    public String postRecover(){
        return "recover";
    }

    @GetMapping("room-details")
    public String getRoomDetails(){
        return "room-details";
    }
    @PostMapping("room-details")
    public String postRoomDetails(){
        return "room-details";
    }

    @GetMapping("room-gird")
    public String getRoomGird(){
        return "room-gird";
    }
    @PostMapping("room-gird")
    public String postRoomGird(){
        return "room-gird";
    }

    @GetMapping("room-list")
    public String getRoomList(){
        return "room-list";
    }
    @PostMapping("room-list")
    public String postRoomList(){
        return "room-list";
    }

    @GetMapping("room-search-result")
    public String getRoomSearchResult(){
        return "room-search-result";
    }
    @PostMapping("room-search-result")
    public String postRoomSearchResult(){
        return "room-search-result";
    }

    @GetMapping("room-search-result-list")
    public String getRoomSearchResultList(){
        return "room-search-result-list";
    }
    @PostMapping("room-search-result-list")
    public String postRoomSearchResultList(){
        return "room-search-result-list";
    }

    @GetMapping("user-profile")
    public String getUserProfile(){
        return "user-profile";
    }
    @PostMapping("user-profile")
    public String postUserProfile(){
        return "user-profile";
    }

}

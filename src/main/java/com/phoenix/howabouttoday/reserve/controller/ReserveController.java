package com.phoenix.howabouttoday.reserve.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ReserveController {

    @GetMapping("hotel-booking")
    public String getHotelBooking(){
        return "reserve/hotel-booking";
    }
    @PostMapping("hotel-booking")
    public String postHotelBooking(){
        return "reserve/hotel-booking";
    }

    @GetMapping("checkout")
    public String getCheckout(){
        return "reserve/checkout";
    }
    @PostMapping("checkout")
    public String postCheckout(){
        return "reserve/checkout";
    }

    @GetMapping("payment-received")
    public String getPaymentReceived(){
        return "reserve/payment-received";
    }
    @PostMapping("payment-received")
    public String postPaymentReceived(){
        return "reserve/payment-received";
    }

    @GetMapping("payment-complete")
    public String getPaymentComplete(){
        return "reserve/payment-complete";
    }
    @PostMapping("payment-complete")
    public String postPaymentComplete(){
        return "reserve/payment-complete";
    }

}

package com.phoenix.howabouttoday.payment.controller;

import com.phoenix.howabouttoday.payment.service.AccomodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class Payment {

    private final AccomodationService accomodationService;


    @GetMapping("user-dashboard-booking-details")
    public String getUserDashboardSettings() {

        accomodationService.getQuestion();
        return "reserve/payment-received";
    }
    @PostMapping("user-dashboard-booking-details")
    public String postUserDashboardSettings() {
        return "reserve/payment-received";
    }
}

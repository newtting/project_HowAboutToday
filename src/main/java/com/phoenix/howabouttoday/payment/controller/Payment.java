package com.phoenix.howabouttoday.payment.controller;

import com.phoenix.howabouttoday.accom.service.AccomodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Payment {


    private final AccomodationService accomodationService;

    @Autowired
    public Payment(AccomodationService accomodationService) {
        this.accomodationService = accomodationService;
    }

    @GetMapping("user-dashboard-booking-details")
    public String getUserDashboardSettings() {

        //accomodationService.createMember();
        return "reserve/payment-received";
    }
    @PostMapping("user-dashboard-booking-details")
    public String postUserDashboardSettings() {
        return "reserve/payment-received";
    }

    @GetMapping("user-dashboard-bookings")
    public String getUserDashboard() {



//        accomodationService.getReadMember();

        return "member/userdashboard/user-dashboard-booking";
    }
    @PostMapping("user-dashboard-bookings")
    public String postUserDashboard() {
        return "member/userdashboard/user-dashboard-booking";
    }


}

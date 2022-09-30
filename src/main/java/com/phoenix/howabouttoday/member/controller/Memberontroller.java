package com.phoenix.howabouttoday.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class Memberontroller {

    @GetMapping("user-dashboard")
    public String getUserDashboard() {
        return "userdashboard/user-dashboard";
    }

    @PostMapping("user-dashboard")
    public String postUserDashboard() {
        return "userdashboard/user-dashboard";
    }

    @GetMapping("user-dashboard-booking")
    public String getUserDashboardBooking() {
        return "userdashboard/user-dashboard-booking";
    }

    @PostMapping("user-dashboard-booking")
    public String postUserDashboardBooking() {
        return "userdashboard/user-dashboard-booking";
    }

    @GetMapping("user-dashboard-profile")
    public String getUserDashboardProfile() {
        return "userdashboard/user-dashboard-profile";
    }

    @PostMapping("user-dashboard-profile")
    public String postUserDashboardProfile() {
        return "userdashboard/user-dashboard-profile";
    }

    @GetMapping("user-dashboard-reviews")
    public String getUserDashboardReviews() {
        return "userdashboard/user-dashboard-reviews";
    }

    @PostMapping("user-dashboard-reviews")
    public String postUserDashboardReviews() {
        return "userdashboard/user-dashboard-reviews";
    }

    @GetMapping("user-dashboard-settings")
    public String getUserDashboardSettings() {
        return "userdashboard/user-dashboard-settings";
    }

    @PostMapping("user-dashboard-settings")
    public String postUserDashboardSettings() {
        return "userdashboard/user-dashboard-settings";
    }

    @GetMapping("user-dashboard-wishlist")
    public String getUserDashboardWishList() {
        return "userdashboard/user-dashboard-wishlist";
    }

    @PostMapping("user-dashboard-wishlist")
    public String postUserDashboardWishList() {
        return "userdashboard/user-dashboard-wishlist";
    }

}

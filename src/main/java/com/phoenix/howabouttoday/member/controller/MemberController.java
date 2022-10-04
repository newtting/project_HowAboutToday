package com.phoenix.howabouttoday.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("recover")
    public String getRecover(){
        return "member/recover";
    }
    @PostMapping("recover")
    public String postRecover(){
        return "member/recover";
    }

    @GetMapping("user-dashboard")
    public String getUserDashboard() {
        return "member/userdashboard/user-dashboard";
    }
    @PostMapping("user-dashboard")
    public String postUserDashboard() {
        return "member/userdashboard/user-dashboard";
    }

    @GetMapping("user-dashboard-booking")
    public String getUserDashboardBooking() {
        return "member/userdashboard/user-dashboard-booking";
    }
    @PostMapping("user-dashboard-booking")
    public String postUserDashboardBooking() {
        return "member/userdashboard/user-dashboard-booking";
    }

    @GetMapping("user-dashboard-profile")
    public String getUserDashboardProfile() {
        return "member/userdashboard/user-dashboard-profile";
    }
    @PostMapping("user-dashboard-profile")
    public String postUserDashboardProfile() {
        return "member/userdashboard/user-dashboard-profile";
    }

    @GetMapping("user-dashboard-reviews")
    public String getUserDashboardReviews() {
        return "member/userdashboard/user-dashboard-reviews";
    }
    @PostMapping("user-dashboard-reviews")
    public String postUserDashboardReviews() {
        return "member/userdashboard/user-dashboard-reviews";
    }

    @GetMapping("user-dashboard-settings")
    public String getUserDashboardSettings() {
        return "member/userdashboard/user-dashboard-settings";
    }
    @PostMapping("user-dashboard-settings")
    public String postUserDashboardSettings() {
        return "member/userdashboard/user-dashboard-settings";
    }


}

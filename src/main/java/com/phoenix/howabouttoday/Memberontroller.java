package com.phoenix.howabouttoday;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class Memberontroller {

    @GetMapping("about")
    public String getAbout() {
        return "commons/about";
    }

    @PostMapping("about")
    public String postAbout() {
        return "commons/about";
    }

    @GetMapping("blog-grid")
    public String getBlogGrid() {
        return "blog/blog-grid";
    }

    @PostMapping("blog-grid")
    public String postBlogGrid() {
        return "blog/blog-grid";
    }

    @GetMapping("faq")
    public String getFaq() {
        return "commons/faq";
    }

    @PostMapping("faq")
    public String postFaq() {
        return "commons/faq";
    }

    @GetMapping("contact")
    public String getContact() {
        return "commons/contact";
    }

    @PostMapping("contact")
    public String postContact() {
        return "commons/contact";
    }

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

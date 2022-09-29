package com.phoenix.howabouttoday;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class Memberontroller {

    @GetMapping("about")
    public String getAbout(){
        return "about";
    }
    @PostMapping("about")
    public String postAbout(){
        return "about";
    }

    @GetMapping("blog-grid")
    public String getBlogGrid(){
        return "blog-grid";
    }
    @PostMapping("blog-grid")
    public String postBlogGrid(){
        return "blog-grid";
    }

    @GetMapping("faq")
    public String getFaq(){
        return "faq";
    }
    @PostMapping("faq")
    public String postFaq(){
        return "faq";
    }

    @GetMapping("contact")
    public String getContact(){
        return "contact";
    }
    @PostMapping("contact")
    public String postContact(){
        return "contact";
    }

    @GetMapping("user-dashboard")
    public String getUserDashboard(){
        return "user-dashboard";
    }
    @PostMapping("user-dashboard")
    public String postUserDashboard(){
        return "user-dashboard";
    }

    @GetMapping("user-dashboard-booking")
    public String getUserDashboardBooking(){
        return "user-dashboard-booking";
    }
    @PostMapping("user-dashboard-booking")
    public String postUserDashboardBooking(){
        return "user-dashboard-booking";
    }

    @GetMapping("user-dashboard-profile")
    public String getUserDashboardProfile(){
        return "user-dashboard-profile";
    }
    @PostMapping("user-dashboard-profile")
    public String postUserDashboardProfile(){
        return "user-dashboard-profile";
    }

    @GetMapping("user-dashboard-reviews")
    public String getUserDashboardReviews(){
        return "user-dashboard-reviews";
    }
    @PostMapping("user-dashboard-reviews")
    public String postUserDashboardReviews(){
        return "user-dashboard-reviews";
    }

    @GetMapping("user-dashboard-settings")
    public String getUserDashboardSettings(){
        return "user-dashboard-settings";
    }
    @PostMapping("user-dashboard-settings")
    public String postUserDashboardSettings(){
        return "user-dashboard-settings";
    }

    @GetMapping("user-dashboard-wishlist")
    public String getUserDashboardWishList(){
        return "user-dashboard-wishlist";
    }
    @PostMapping("user-dashboard-wishlist")
    public String postUserDashboardWishList(){
        return "user-dashboard-wishlist";
    }

}

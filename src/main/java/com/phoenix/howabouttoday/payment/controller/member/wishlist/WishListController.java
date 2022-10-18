package com.phoenix.howabouttoday.payment.controller.member.wishlist;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user-dashboard-wishlist")
@RequiredArgsConstructor
public class WishListController {

    @GetMapping
    public String getWishList() {
        log.info("GET 위시리스트 호출!! ");
        return "member/userdashboard/user-dashboard-wishlist";
    }
    @PostMapping
    public String postWishList() {
        return "member/userdashboard/user-dashboard-wishlist";
    }


}

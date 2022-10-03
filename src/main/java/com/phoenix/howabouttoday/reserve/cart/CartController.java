package com.phoenix.howabouttoday.reserve.cart;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    @GetMapping
    public String getCart(){
        log.info("getCart 호출");
        return "reserve/cart";
    }
    @PostMapping
    public String addCart(){
        log.info("addCart 호출!!");
        return "reserve/cart";
    }


}

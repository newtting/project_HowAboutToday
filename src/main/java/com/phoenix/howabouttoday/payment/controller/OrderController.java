/**
 *
 * 장바구니에서 결제로 이동 시 처리하는 컨트롤러
 *
 */


package com.phoenix.howabouttoday.payment.controller;

import com.phoenix.howabouttoday.member.Service.MemberService;
import com.phoenix.howabouttoday.member.dto.MemberDTO;
import com.phoenix.howabouttoday.payment.dto.OrdersDetailDto;
import com.phoenix.howabouttoday.payment.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@RequiredArgsConstructor
@Controller
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;

    @GetMapping("checkout")
    public String cartView(Model model/*, @PathVariable Integer id*/){
        /*********************로그인 후 인증정보를 가져 오는 부분 작성***********************/
        //시큐리티를 사용하면 principal 객체에서 user정보를 가져와서 memberNum을 알 수 있다. 이때도 member 엔티티를 사용하는 게 아니라 user라는 dto를 사용해야한다.

        MemberDTO customer = memberService.getCustomer(1L);
        List<OrdersDetailDto> infoList = orderService.getCartData(customer.getNum());
        Integer totalPrice = orderService.getTotalPrice(customer.getNum());
        System.out.println(totalPrice);

        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("customer", customer);
        model.addAttribute("infoList", infoList);

        return "reserve/checkout";
}

    @PostMapping("checkout")
    public String postCheckout(){
        return "reserve/checkout";
    }

    @GetMapping("paymentSuccess")
    public String getUserPaymentSuccess(Model model) {
        MemberDTO customer = memberService.getCustomer(1L);
        orderService.savePaymentData(customer.getNum(), "이동우", "010-1234-5678");


        return "reserve/payment-complete";
    }

    @PostMapping("paymentSuccess")
    public String postUserPaymentSuccess() {

        return "reserve/payment-complete";
    }

}
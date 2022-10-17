package com.phoenix.howabouttoday.payment.controller;


import com.phoenix.howabouttoday.member.Service.MemberService;
import com.phoenix.howabouttoday.payment.dto.Customer;
import com.phoenix.howabouttoday.payment.dto.OrderDto;
import com.phoenix.howabouttoday.payment.service.OrderService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
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
    public String cartView(Model model){
        /*********************로그인 후 인증정보를 가져 오는 부분 작성***********************/
        //시큐리티를 사용하면 principal 객체에서 user정보를 가져와서 memberNum을 알 수 있다. 이때도 member 엔티티를 사용하는 게 아니라 user라는 dto를 사용해야한다.

        Customer customer = memberService.getCustomer(1L);
        List<OrderDto> infoList = orderService.getCartData(customer.getNum());
        Integer totalPrice = orderService.getTotalPrice(infoList);

        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("customer", customer);
        model.addAttribute("infoList", infoList);

        return "reserve/checkout";
    }

    @PostMapping("checkout")
    public String postCheckout(){
        return "reserve/checkout";
    }
}

package com.phoenix.howabouttoday.payment.controller;

import com.phoenix.howabouttoday.accom.service.AccomodationService;
import com.phoenix.howabouttoday.member.Service.MemberService;
import com.phoenix.howabouttoday.member.dto.MemberDTO;
import com.phoenix.howabouttoday.payment.dto.OrdersDTO;
import com.phoenix.howabouttoday.payment.dto.OrdersDetailVO;
import com.phoenix.howabouttoday.payment.service.OrdersService;
import com.phoenix.howabouttoday.room.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@AllArgsConstructor
@Controller
@Slf4j
public class PaymentController {

    private final MemberService memberService;
    private final OrdersService orderService;

    /* 마이페이지-예약탭  */
    @GetMapping("user-dashboard-booking")
    public String getUserDashboard(Model model, Principal principal, Authentication authentication){
        //1. 시큐리티를 사용해서 principal 객체에서 user정보를 가져와서 memberNum을 알 수 있다.



//        MemberDTO customer = memberService.getCustomer(1L);
        MemberDTO customer = memberService.getAuthUser(principal.getName());
        List<OrdersDTO> ordersDTOList = orderService.getOrdersDTOList(customer.getNum());


        model.addAttribute("customer", customer);
        model.addAttribute("ordersDTOList", ordersDTOList);
        return "member/userdashboard/user-dashboard-booking";
    }

    @PostMapping("user-dashboard-booking")
    public String postUserDashboard() {
        return "member/userdashboard/user-dashboard-booking";
    }

}

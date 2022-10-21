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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
@Slf4j
public class PaymentController {

    private final MemberService memberService;
    private final OrdersService orderService;


    /* 마이페이지-예약탭  */
    @GetMapping(value = {"user-dashboard-booking/{page}", "user-dashboard-booking"})
    public String getUserBooking(@PathVariable(required = false, name = "page") Optional<Integer> page, Model model) {
//
    Integer curPage = page.orElse(1);


        //1. 시큐리티를 사용해서 principal 객체에서 user정보를 가져와서 memberNum을 알 수 있다.

        MemberDTO customer = memberService.getCustomer(3L);
//        MemberDTO customer = memberService.getAuthUser(principal.getName());

        Page<OrdersDTO> ordersDTOList = orderService.pagingAll(PageRequest.of(curPage - 1, 5, Sort.Direction.ASC, "ordersDate"));

        model.addAttribute("customer", customer);
        model.addAttribute("ordersDTOList", ordersDTOList);
        return "member/userdashboard/user-dashboard-booking";
    }

    @PostMapping("user-dashboard-booking")
    public String postUserDashboard() {
        return "member/userdashboard/user-dashboard-booking";
    }

}

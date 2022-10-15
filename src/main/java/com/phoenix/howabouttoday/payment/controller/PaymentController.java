package com.phoenix.howabouttoday.payment.controller;

import com.phoenix.howabouttoday.accom.service.AccomodationService;
import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.payment.dto.Customer;
import com.phoenix.howabouttoday.payment.dto.OrderHistory;
import com.phoenix.howabouttoday.payment.entity.Orders;
import com.phoenix.howabouttoday.payment.service.MemberServiceCopy;
import com.phoenix.howabouttoday.room.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
@Slf4j
public class PaymentController {


    private final MemberServiceCopy memberServiceCopy;
    private final AccomodationService accomodationService;
    private final RoomService roomService;






    @GetMapping("user-dashboard-booking-details")
    public String getUserDashboardSettings() {


        return "reserve/payment-received";
    }
    @PostMapping("user-dashboard-booking-details")
    public String postUserDashboardSettings() {
        return "reserve/payment-received";
    }


    @GetMapping("user-dashboard-booking")
    public String getUserDashboard(Principal principal, Authentication authentication, Model model) {
        /*********************로그인 후 인증정보를 가져 오는 부분 작성***********************/
        try {
            Customer customer = memberServiceCopy.getCustomer(2L);

            List<Orders> orders = customer.getOrders();
            List<OrderHistory> orderHistory = new ArrayList<>();

            orders.forEach(order -> {
                order.getReservation().forEach(reservation -> {
                    orderHistory.add(OrderHistory.builder()
                            .accomType(reservation.getAccommodation().getAccomCategory().getValue())
                            .accomName(reservation.getAccommodation().getAccomName())
                            .accomRegion(reservation.getAccommodation().getRegion().getRegion().getValue())
                            .orderDate(order.getOrdersDate().toString())
                            .usePeriod(reservation.getReserveUseStartDate().toString() + " ~ " + reservation.getReserveUseEndDate().toString())
                            .totalPrice(String.valueOf(reservation.getReservePrice()))
                            .usedStatus(reservation.getReserveStatus().toString())
                            .roomName(reservation.getRoom().getRoomName())
                            .checkTime("입실: 오후 15시, 퇴실: 오전 11시")
                            .build());
                });
            });


        System.out.println(orderHistory.size());

        model.addAttribute("orderHistory", orderHistory);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return "member/userdashboard/user-dashboard-booking";
    }
    @PostMapping("user-dashboard-booking")
    public String postUserDashboard() {
        return "member/userdashboard/user-dashboard-booking";
    }

    @GetMapping("checkout")
    public String getCheckout(){
        System.out.println("췍췍");


        /*
        이 매핑으로 오는 정보는 대략 2가지로 나눌 수 있다.
        1. 장바구니에서 오는 예약할 숙소 리스트 정보
        2. 객실에서 곧바로 결제로 오는 숙소 1개의 정보

        이걸 코드상으로 구현해서 테스트를 해보자.
        숙소 + 객실 정보를 reservation 객체로 만들면 된다.
        */


        
        
        
        
        return "reserve/checkout";
    }
    @PostMapping("checkout")
    public String postCheckout(){
        return "reserve/checkout";
    }


}

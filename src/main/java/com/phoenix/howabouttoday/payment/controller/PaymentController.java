package com.phoenix.howabouttoday.payment.controller;

import com.phoenix.howabouttoday.accom.entity.Accommodation;
import com.phoenix.howabouttoday.accom.service.AccomodationService;
import com.phoenix.howabouttoday.payment.dto.CheckOutAccomRoomDTO;
import com.phoenix.howabouttoday.payment.dto.Customer;
import com.phoenix.howabouttoday.payment.dto.OrderDto;
import com.phoenix.howabouttoday.payment.entity.Orders;
import com.phoenix.howabouttoday.payment.service.MemberServiceCopy;
import com.phoenix.howabouttoday.payment.service.OrderSuccessService;
import com.phoenix.howabouttoday.room.entity.Room;
import com.phoenix.howabouttoday.room.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
@Slf4j
public class PaymentController {


    private final MemberServiceCopy memberServiceCopy;
    private final AccomodationService accomodationService;
    private final RoomService roomService;
    private final OrderSuccessService orderSuccessService;


    @GetMapping("user-dashboard-booking-details")
    public String getUserDashboardSettings() {


        return "reserve/payment-received";
    }

    @PostMapping("user-dashboard-booking-details")
    public String postUserDashboardSettings() {

        return "reserve/payment-received";
    }

    @GetMapping("paymentSuccess")
    public String getUserPaymentSuccess() {
        System.out.println("결제 성공");



        return "reserve/payment-complete";
    }

    @PostMapping("paymentSuccess")
    public String postUserPaymentSuccess() {

        return "reserve/payment-complete";
    }


    @GetMapping("user-dashboard-booking")
    public String getUserDashboard(Principal principal, Authentication authentication, Model model) {
        /*********************로그인 후 인증정보를 가져 오는 부분 작성***********************/
        try {
            Customer customer = memberServiceCopy.getCustomer(1L);

            List<Orders> orders = customer.getOrders();
            List<OrderDto> orderHistory = new ArrayList<>();

            orders.forEach(order -> {
                order.getReservation().forEach(reservation -> {
                    orderHistory.add(OrderDto.builder()
                            .accomType(reservation.getAccommodation().getAccomCategory().getValue())
                            .accomName(reservation.getAccommodation().getAccomName())
                            .accomRegion(reservation.getAccommodation().getRegion().getRegion().getValue())
                            .orderDate(order.getOrdersDate().toString())
                            .usePeriod(reservation.getReserveUseStartDate().toString() + " ~ " + reservation.getReserveUseEndDate().toString())
                            .price(String.valueOf(reservation.getReservePrice()))
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

}

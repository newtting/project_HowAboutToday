package com.phoenix.howabouttoday.payment.controller;

import com.phoenix.howabouttoday.accom.entity.Accommodation;
import com.phoenix.howabouttoday.accom.service.AccomodationService;
import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.payment.dto.CheckOutAccomRoomDTO;
import com.phoenix.howabouttoday.payment.dto.Customer;
import com.phoenix.howabouttoday.payment.dto.OrderHistory;
import com.phoenix.howabouttoday.payment.entity.Orders;
import com.phoenix.howabouttoday.payment.service.MemberServiceCopy;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Reservation;
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
    public String getCheckout(Model model/*, Reservation reservation*/){
        /*********************로그인 후 인증정보를 가져 오는 부분 작성***********************/

        /*
        이 매핑으로 오는 정보는 대략 2가지로 나눌 수 있다.
        1. 장바구니에서 오는 예약할 숙소 리스트 정보
        2. 객실에서 곧바로 결제로 오는 숙소 1개의 정보

        이걸 코드상으로 구현해서 테스트를 해보자.
        숙소 + 객실 정보를 reservation 객체로 만들면 된다.
        */

        /*
         * reservation에는 예약객체보다는 pk로 받는 게 좋을 듯
         * 여기서는 임시로 데이터베이스에서 생성하는 것으로 대체
         */

        //여기 정보는 원래라면 request 정보로 받아야 한다.
        final LocalDate today = LocalDate.now();
        final Integer NIGHT = 3;
        final Integer GUEST = 1;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Period period = Period.between(today, today.plusDays(3));
        try {
            Customer customer = memberServiceCopy.getCustomer(2L);
            Accommodation accom = accomodationService.getAccommodationlist().get(0);
            Room room = accom.getRoom().get(0);

            CheckOutAccomRoomDTO info = CheckOutAccomRoomDTO.builder()
                    .accomName(accom.getAccomName())
                    .roomName(room.getRoomName())
                    .checkIn(LocalDateTime.of(today, LocalTime.now()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))) //예약 날짜와 checkinout 시간은 따로 받아도 되고 dto로 받아서 담자
                    .checkOut(LocalDateTime.of(today.plusDays(3), LocalTime.now()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss")))
                    .night(period.getDays()) //몇박인지의 데이터는 accom이나 room의 entity로 표현할 필요는 없어보이고 dto에서만 표현하고 reservation에 담도록 하자.
                    .guest(GUEST)
                    .region(accom.getRegion().getRegion().getValue())
                    .service("조식, 싱글침대 2개")
                    .price(room.getPrice())
                    .build();

            model.addAttribute("customer", customer);
            model.addAttribute("info", info);
        }catch (Exception e){
            System.out.println(e.toString());
        }

        return "reserve/checkout";
    }

    @PostMapping("checkout")
    public String postCheckout(){
        return "reserve/checkout";
    }


}

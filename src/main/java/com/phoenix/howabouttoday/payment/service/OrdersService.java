package com.phoenix.howabouttoday.payment.service;

import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.member.repository.MemberRepository;
import com.phoenix.howabouttoday.payment.dto.OrdersDetailDTO;
import com.phoenix.howabouttoday.payment.dto.OrdersDTO;
import com.phoenix.howabouttoday.payment.dto.OrdersDetailVO;
import com.phoenix.howabouttoday.payment.entity.Orders;
import com.phoenix.howabouttoday.payment.entity.OrdersDetail;
import com.phoenix.howabouttoday.payment.repository.AvailableDateRepository;
import com.phoenix.howabouttoday.payment.repository.OrdersDetailRepository;
import com.phoenix.howabouttoday.payment.repository.OrdersRepository;
import com.phoenix.howabouttoday.reserve.domain.CartRepository;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Cart;
import com.phoenix.howabouttoday.reserve.domain.Reservation.ReserveStatus;
import com.phoenix.howabouttoday.room.dto.AvailableDate;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.FetchType.LAZY;

@Transactional
@RequiredArgsConstructor
@Service
public class OrdersService {

    private final CartRepository cartRepository;
    private final AvailableDateRepository availableDateRepository;
    private final MemberRepository memberRepository;
    private final OrdersRepository ordersRepository;

    public List<OrdersDetailVO> getCartData(List<Long> cartNum){
        return cartRepository.findAllById(cartNum)
                .stream()
                .map(OrdersDetailVO::new)
                .collect(Collectors.toList());
    }

//    public List<OrdersDetailVO> getOrderDetailData(Long ordersNum){
//        return ordersRepository.findById(ordersNum).get().getReservation()
//                .stream()
//                .map(OrdersDetailVO::new)
//                .collect(Collectors.toList());
//    }

    public List<OrdersDetailDTO> createOrdersDetailData(List<Long> cartNum){
        return cartRepository.findAllById(cartNum)
                .stream()
                .map(OrdersDetailDTO::new)
                .collect(Collectors.toList());
    }

    public List<OrdersDTO> getOrdersDTOList(Long memberNum){
        return ordersRepository.findAllByMember_MemberNum(memberNum)
                .stream()
                .map(OrdersDTO::new) // 적용 후
                .collect(Collectors.toList());
    }

    public OrdersDTO getOrdersDTO(Long ordersNum){
        return new OrdersDTO(ordersRepository.findById(ordersNum).get());
    }

    public boolean savePaymentData(Long memberNum, String name, String tel, String ordersType, List<Long> cartNum){

        try {
            Member member = memberRepository.findById(memberNum).get();
            List<Cart> cartList = cartRepository.findAllById(cartNum);

            Orders order = getOrder(name, tel, ordersType, member, cartList);

            List<OrdersDetail> lists = cartList // Entity List
                    .stream() // Entity Stream
                    .map(cart -> ordersNumberMapping(cart, order)) // DTO Stream
                    .collect(Collectors.toList()); // DTO List

            order.getReservation().addAll(lists);

            ordersRepository.save(order);
            cartRepository.deleteAllById(cartNum);
        }
        catch (RuntimeException e){
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    private Orders getOrder(String name, String tel, String ordersType, Member member, List<Cart> cartList) {
        Orders order = Orders.builder()
                .member(member)
                .ordersName(name)
                .ordersTel(tel)
                .ordersDate(LocalDate.now())
                .ordersPrice(getTotalPrice(cartList
                        .stream()
                        .map(cart -> cart.getReserveNum())
                        .collect(Collectors.toList())))
                .ordersType(ordersType)
                .ordersStatus(ReserveStatus.READY.toString())
                .build();
        return order;
    }


    public Integer getTotalPrice(List<Long> cartNum){
        List<Cart> cartList = cartRepository.findAllById(cartNum);
        return cartList
                .stream()
                .mapToInt(Cart::getReservePrice)
                .sum();
    }

    private OrdersDetail ordersNumberMapping(Cart cart, Orders order){

        //예약 날짜를 룸에다가 넣어준다.
        LocalDate startDate = cart.getReserveUseStartDate();
        LocalDate endDate =  cart.getReserveUseEndDate();

        Period period = Period.between(startDate, endDate);
        System.out.println("날짜차이: " + period.getDays());

        OrdersDetail od = OrdersDetail.builder()
                .member(cart.getMember())
                .room(cart.getRoom())
                .orders(order)
                .reserveStatus(ReserveStatus.READY)
                .reserveUseStartDate(cart.getReserveUseStartDate())
                .reserveUseEndDate(cart.getReserveUseEndDate())
                .reservePrice(cart.getReservePrice())
                .reserveAdultCount(cart.getReserveAdultCount())
                .reserveChildCount(cart.getReserveChildCount())
                .build();

        for (int i = 0; i < period.getDays(); i++) {
            AvailableDate ad = AvailableDate.builder()
                    .date(startDate.plusDays(i))
                    .room(od.getRoom())
                    .build();
            od.getRoom().getAvailableDate().add(ad);
        }
        return od;
    }
}

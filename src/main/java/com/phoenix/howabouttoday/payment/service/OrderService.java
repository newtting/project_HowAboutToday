package com.phoenix.howabouttoday.payment.service;

import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.member.repository.MemberRepository;
import com.phoenix.howabouttoday.payment.dto.Customer;
import com.phoenix.howabouttoday.payment.dto.OrderDto;
import com.phoenix.howabouttoday.payment.entity.OrdersDetail;
import com.phoenix.howabouttoday.payment.entity.OrdersDetailRepository;
import com.phoenix.howabouttoday.payment.repository.OrdersRepository;
import com.phoenix.howabouttoday.reserve.domain.CartRepository;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Cart;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Reservation;
import com.phoenix.howabouttoday.reserve.domain.Reservation.ReserveStatus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final CartRepository cartRepository;

    public List<OrderDto> getCartData(Long memberId){

        List<Cart> cartList = cartRepository.findAllByMember_MemberNum(memberId);
        List<OrderDto> orderDtoList = new ArrayList<>();

        cartList.forEach(cart -> {
            orderDtoList.add(cart.transDto());
        });
        return orderDtoList;
    }

    public Integer getTotalPrice(List<OrderDto> orderDtoList){
        Integer totalPrice = 0;

        for (OrderDto dto: orderDtoList) {
            totalPrice += Integer.parseInt(dto.getPrice());
        }

        return totalPrice;
    }


}

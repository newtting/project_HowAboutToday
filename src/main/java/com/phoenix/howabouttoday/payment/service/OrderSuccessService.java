package com.phoenix.howabouttoday.payment.service;

import com.phoenix.howabouttoday.payment.dto.OrderDto;
import com.phoenix.howabouttoday.payment.entity.Orders;
import com.phoenix.howabouttoday.payment.repository.OrdersRepository;
import com.phoenix.howabouttoday.reserve.domain.CartRepository;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Cart;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderSuccessService {

    private final CartRepository cartRepository;
    private final OrdersRepository ordersRepository;

    public boolean savePaymentData(Long memberId){

        List<Cart> cartList = cartRepository.findAllByMember_MemberNum(memberId);
        Orders order = Orders.builder().build();
        
        //cart데이터로 order를 생성

        return true;
    }
}

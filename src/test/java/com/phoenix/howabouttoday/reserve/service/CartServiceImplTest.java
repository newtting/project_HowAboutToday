package com.phoenix.howabouttoday.reserve.service;

import com.phoenix.howabouttoday.accom.repository.AccommodationRepository;
import com.phoenix.howabouttoday.accom.repository.RegionRepository;
import com.phoenix.howabouttoday.reserve.domain.CartRepository;
import com.phoenix.howabouttoday.reserve.domain.MemberRepository;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Cart;
import com.phoenix.howabouttoday.reserve.domain.RoomRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;



@SpringBootTest
@Transactional
class CartServiceImplTest {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    RegionRepository regionRepository;
    @Autowired
    AccommodationRepository accommodationRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired CartService cartService;

    @Test
    public void 장바구니저장_테스트() throws Exception{
        //given
        ReserveForm rsForm = new ReserveForm();
        rsForm.setReserveUseStartDate(LocalDateTime.now());
        rsForm.setReserveUseEndDate(LocalDateTime.now());
        rsForm.setReserveAdultCount(2);

        Cart saveCart = cartService.save(1L, 2L, rsForm);

        Optional<Cart> byId = cartRepository.findById(saveCart.getReserveNum());
        Cart findCart = byId.get();

        Assertions.assertThat(saveCart.getReserveNum()).isEqualTo(findCart.getReserveNum());



        //when


        //then
    }

}
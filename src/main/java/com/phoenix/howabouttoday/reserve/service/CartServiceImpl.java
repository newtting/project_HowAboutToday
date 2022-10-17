package com.phoenix.howabouttoday.reserve.service;


import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.member.repository.MemberRepository;
import com.phoenix.howabouttoday.reserve.domain.CartRepository;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Cart;
import com.phoenix.howabouttoday.room.entity.Room;
import com.phoenix.howabouttoday.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService{


    private final CartRepository cartRepository;
    private final MemberRepository memberRepository;
    private final RoomRepository roomRepository;


    @Override
    public boolean checkHaveCart(Long memberNum) {
        return false;
    }

    @Override
    public void deleteAll(Long memberNum) {

    }

    @Override
    public void deleteByNum(Long cartNum) {

    }

    @Override
    public List<CartDto.ResponseDto> getListMemberNum(Long memberNum) {
        Member member = memberRepository.findById(memberNum).orElseThrow(() ->
                new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));

        List<Cart> cartList = cartRepository.findAllByMember_MemberNum(member.getMemberNum());

        return cartList.stream().map(CartDto.ResponseDto::new).collect(Collectors.toList());


    }

    @Override
    public boolean checkCart(Long memberNum, Long roomNum) {
        return false;
    }

    @Override
    public Cart save(Long memberNum, Long roomNum , ReserveForm reserveForm) {
        Member member = memberRepository.findById(memberNum).orElseThrow(() ->
                new IllegalArgumentException("해당 회원이 존재하지 않습니다."));
        Room room = roomRepository.findById(roomNum).orElseThrow(() ->
                new IllegalArgumentException("해당 숙소가 존재하지 않습니다."));

        /* DB에 cart 저장 */
        Cart saveCart = cartRepository.save(Cart.builder()
                .member(member)
                .room(room)
                .reserveUseStartDate(reserveForm.getReserveUseStartDate())
                .reserveUseEndDate(reserveForm.getReserveUseEndDate())
                .reserveAdultCount(reserveForm.getReserveAdultCount())
                .reserveChildCount(reserveForm.getReserveChildCount()).build());

        return saveCart;
    }
}



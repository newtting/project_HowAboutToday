package com.phoenix.howabouttoday.room.service;

import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.member.repository.MemberRepository;
import com.phoenix.howabouttoday.payment.entity.Orders;
import com.phoenix.howabouttoday.payment.repository.OrdersRepository;
import com.phoenix.howabouttoday.room.dto.*;
import com.phoenix.howabouttoday.room.entity.Room;
import com.phoenix.howabouttoday.room.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final RoomRepository roomRepository;
    private final OrdersRepository ordersRepository;
    private final MemberRepository memberRepository;

    @Override
    public Boolean isReserve(Long memberNum, Long roomNum) {
        Member member = memberRepository.findById(memberNum).orElseThrow(() -> new IllegalArgumentException(String.format("%d번 멤버가 존재하지 않습니다.", memberNum)));
        Room room = roomRepository.findById(roomNum).orElseThrow(() -> new IllegalArgumentException(String.format("%d번 객실이 존재하지 않습니다.", roomNum)));

        List<Orders> ordersList = ordersRepository.findAllByMember_MemberNum(memberNum);


        return null;
    }

    @Override
    public Boolean isPassedTwoWeeks(Long memberNum, Long roomNum, LocalDate localDate) {
        return null;
    }
}

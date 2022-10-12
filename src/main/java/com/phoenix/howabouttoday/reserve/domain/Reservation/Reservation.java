package com.phoenix.howabouttoday.reserve.domain.Reservation;

import com.phoenix.howabouttoday.accom.Accommodation;
import com.phoenix.howabouttoday.accom.entity.Accommodation;
import com.phoenix.howabouttoday.member.Member;
import com.phoenix.howabouttoday.payment.Order;
import com.phoenix.howabouttoday.payment.Pay;
import com.phoenix.howabouttoday.room.Room;
import com.phoenix.howabouttoday.room.entity.Room;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.FetchType.*;


/**
 * reserveNum = PK번호
 * member = 회원
 * accommodation = 숙소
 * room = 객실
 * orders = 주문
 * reserveStatus = 예약상태 [READY,COMP]
 * reserveUseStartDate = 희망 사용 날짜
 * reserveUseEndDate = 희망 종료 날짜
 * reservePrice = 주문예상가격
 * reserveAdultCount = 인원(성인)
 * reserveChildCount = 인원(아동)
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@DiscriminatorColumn(name = "reserve_type")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "t_reservation")
public abstract class Reservation {

    @Id @GeneratedValue
    private Long reserveNum;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_num")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "accom_num")
    private Accommodation accommodation;

    @ManyToOne
    @JoinColumn(name = "room_num")
    private Room room;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "pay_num")
    private Orders orders;

    @Enumerated(EnumType.STRING)
    private ReserveStatus reserveStatus;


    private LocalDate reserveUseStartDate;
    private LocalDate reserveUseEndDate;

    private int reservePrice;
    private int reserveAdultCount;
    private int reserveChildCount;




}

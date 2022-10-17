package com.phoenix.howabouttoday.board.entity;


import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Reservation;


import com.phoenix.howabouttoday.payment.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long reviewNum;

    @ManyToOne
    @JoinColumn(name = "reserve_num")
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_num")
    private Member member;

    private LocalDateTime reviewCreatedDate;
    private LocalDateTime reviewModifyDate;

    @ManyToOne
    @JoinColumn(name = "order_num")
    private Orders order;


    private Double reviewRating;
    private String reviewContent;


}
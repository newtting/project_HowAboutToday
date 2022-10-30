package com.phoenix.howabouttoday.room.entity;


import com.phoenix.howabouttoday.accom.entity.Accommodation;
import com.phoenix.howabouttoday.member.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_num")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_num")
    private Room room;


    private LocalDate reviewCreateDate;
    private LocalDate reviewModifyDate;

    private Double reviewRating;
    private String reviewContent;
}
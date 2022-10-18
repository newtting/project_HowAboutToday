
package com.phoenix.howabouttoday.payment.entity;

import com.phoenix.howabouttoday.accom.entity.Region;
import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Cart;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Reservation;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordersNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberNum")
    private Member member; //숙소 지역 번호


    @Column(length = 50)
    private String ordersTel;


    @Column(length = 50)
    private String ordersName;


    @Column(length = 50)
    private LocalDate ordersDate;


    private Integer ordersPrice;


    @Column(length = 50)
    private String ordersType;


    @Column(length = 50)
    private String ordersStatus;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<Reservation> reservation = new ArrayList<>(); //이미지 fk를 위한 매핑

    @Builder
    public Orders(Long ordersNum, String ordersTel, String ordersName, LocalDate ordersDate, Integer ordersPrice, String ordersType, String ordersStatus, Member member) {
        this.ordersNum = ordersNum;
        this.ordersTel = ordersTel;
        this.ordersName = ordersName;
        this.ordersDate = ordersDate;
        this.ordersPrice = ordersPrice;
        this.ordersType = ordersType;
        this.ordersStatus = ordersStatus;
        this.member = member;
    }
}
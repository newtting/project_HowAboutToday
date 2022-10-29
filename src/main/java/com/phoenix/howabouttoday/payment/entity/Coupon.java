package com.phoenix.howabouttoday.payment.entity;


import com.phoenix.howabouttoday.global.OrdersStatusConverter;
import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.payment.enumType.CouponStatus;
import com.phoenix.howabouttoday.payment.enumType.CouponStatusConverter;
import com.phoenix.howabouttoday.payment.enumType.DiscountType;
import com.phoenix.howabouttoday.payment.enumType.DiscountTypeConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "couponRulesNum")
    private CouponRules couponRules;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberNum")
    private Member member;

    //이것도 enum으로?
    @Column
    @Convert(converter = CouponStatusConverter.class)
    private CouponStatus status;

    @Column
    private LocalDate assignedDate; //지급날짜

    @Column
    private LocalDate endDate;      //만료날짜
}
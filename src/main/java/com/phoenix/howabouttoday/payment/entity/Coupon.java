package com.phoenix.howabouttoday.payment.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
@Getter
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long couponNum;

    private Integer code;

    //이건 아마 enum으로 관리 해야할듯
    private String discountType;

    private Integer discountValue;

    //이것도 enum으로?
    private String status;

    private LocalDate createdDate;  //생성날짜
    private LocalDate updateDate;   //변경날짜
    private LocalDate endDate;      //만료날짜
    private LocalDate assignedDate; //지급날짜


}


//    CREATE TABLE COUPON (
//        couponNum int auto_increment,
//        couponName varchar(50) NOT NULL,
//  discountPrice int NOT NULL, --  고정 할인 금액
//          couponStartDate datetime NOT NULL,
//          couponEndDate datetime NOT NULL,
//          useTerms int NOT NULL,  --  사용 조건(ex. 40,000원 이상)
//          PRIMARY KEY (`couponNum`)
//          )AUTO_INCREMENT=1;
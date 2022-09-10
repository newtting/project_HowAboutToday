package com.phoenix.howabouttoday.dto;

public class CouponDTO {

    private int couponNum;//쿠폰 번호
    private String couponName;//쿠폰 이름
    private int discountPrice;//할인 금액
    private double couponStartDate;//쿠폰 사용 시작일
    private double couponEndDate;//쿠폰 사용 종료일
    private int useTerms;//사용 조건(ex. 40,000원 이상)

}

package com.phoenix.howabouttoday.reserve.dto;

import lombok.Data;

@Data
public class CartDTO {

    private String reserveStartDate;//예약 시작일
    private String reserveEndDate;//예약 종료일
    private int accomPrice;//숙소 금액

}

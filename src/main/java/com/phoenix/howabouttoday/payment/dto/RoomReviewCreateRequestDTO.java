package com.phoenix.howabouttoday.payment.dto;

import lombok.Getter;

@Getter
public class RoomReviewCreateRequestDTO {

    private Long roomNum;
    private Long orderNum;
    private String name;
    private String content;
    private Integer rating;
}

package com.phoenix.howabouttoday.payment.dto;

import com.phoenix.howabouttoday.payment.enumType.ReviewResponseCode;
import lombok.Getter;

@Getter
public class RoomReviewCreateResponseDTO {

    private ReviewResponseCode code = ReviewResponseCode.NOT_MEMBER;
    private String name;
    private String content;
}

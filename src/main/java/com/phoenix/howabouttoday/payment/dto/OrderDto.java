package com.phoenix.howabouttoday.payment.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderDto {
    private String accomType;
    private String accomName;
    private String accomRegion;
    private String orderDate;
    private String usePeriod;
    private String price;
    private String usedStatus;
    private String roomName;
    private String checkTime;

}

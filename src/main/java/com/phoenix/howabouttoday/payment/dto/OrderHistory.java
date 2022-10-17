package com.phoenix.howabouttoday.payment.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderHistory {
    private String accomType;
    private String accomName;
    private String accomRegion;
    private String orderDate;
    private String usePeriod;
    private String totalPrice;
    private String usedStatus;
    private String roomName;
    private String checkTime;

}

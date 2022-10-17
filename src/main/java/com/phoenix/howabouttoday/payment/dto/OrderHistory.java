package com.phoenix.howabouttoday.payment.dto;


import com.phoenix.howabouttoday.accom.RegionType;
import com.phoenix.howabouttoday.payment.testDriver.AccomCategory;
import com.phoenix.howabouttoday.reserve.domain.Reservation.ReserveStatus;
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

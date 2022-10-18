
/**
 * 주문내역에서 보여줄 주문 dto
 *
 */

package com.phoenix.howabouttoday.payment.dto;

import com.phoenix.howabouttoday.payment.entity.OrdersDetail;
import lombok.Builder;
import lombok.Getter;

import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Locale;

@Getter
@Builder
public class OrdersDetailDto {
    private String accomType;
    private String accomName;
    private String accomRegion;
    private String orderDate;
    private String usePeriod;
    private String startDate;
    private String endDate;
    private String startWeek;
    private String endWeek;
    private String price;
    private String usedStatus;
    private String roomName;
    private String checkIn;
    private String checkOut;

    public OrdersDetailDto(String accomType, String accomName, String accomRegion, String orderDate, String usePeriod, String startDate, String endDate, String startWeek, String endWeek, String price, String usedStatus, String roomName, String checkIn, String checkOut) {
        this.accomType = accomType;
        this.accomName = accomName;
        this.accomRegion = accomRegion;
        this.orderDate = orderDate;
        this.usePeriod = usePeriod;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.price = price;
        this.usedStatus = usedStatus;
        this.roomName = roomName;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public OrdersDetailDto(OrdersDetail ordersDetail){
        this.accomType = ordersDetail.getRoom().getAccommodation().getAccomCategory().getValue();
        this.accomName = ordersDetail.getRoom().getAccommodation().getAccomName();
        this.accomRegion = ordersDetail.getRoom().getAccommodation().getRegion().getRegion().getValue();
        this.orderDate = LocalDate.now().toString();
        this.usePeriod = ordersDetail.transDto().getUsePeriod();
        this.startDate = ordersDetail.transDto().getStartDate();
        this.endDate = ordersDetail.transDto().getEndDate();
        this.startWeek = ordersDetail.transDto().getStartWeek();
        this.endWeek = ordersDetail.transDto().getEndWeek();
        this.price = ordersDetail.transDto().getPrice();
        this.usedStatus = ordersDetail.transDto().getUsedStatus();
        this.roomName = ordersDetail.transDto().getRoomName();
        this.checkIn = ordersDetail.transDto().getCheckIn();
        this.checkOut = ordersDetail.transDto().getCheckOut();
    }
}

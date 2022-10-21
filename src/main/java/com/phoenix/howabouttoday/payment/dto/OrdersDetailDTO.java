
/**
 * 주문내역에서 보여줄 주문 dto
 *
 */

package com.phoenix.howabouttoday.payment.dto;

import com.phoenix.howabouttoday.reserve.domain.Reservation.Cart;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Reservation;
import lombok.Builder;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Locale;

@Getter
@Builder
public class OrdersDetailDTO {
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


    public OrdersDetailDTO(String accomType, String accomName, String accomRegion, String orderDate, String usePeriod, String startDate, String endDate, String startWeek, String endWeek, String price, String usedStatus, String roomName, String checkIn, String checkOut) {
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

    public OrdersDetailDTO(Reservation reservation) {

        Period period = Period.between(reservation.getReserveUseStartDate(), reservation.getReserveUseEndDate());
        String startDay = reservation.getReserveUseStartDate().getDayOfWeek().getDisplayName(TextStyle.NARROW, Locale.KOREAN);
        String endDay = reservation.getReserveUseEndDate().getDayOfWeek().getDisplayName(TextStyle.NARROW, Locale.KOREAN);

        this.accomType = reservation.getRoom().getAccommodation().getAccomCategory().getValue();
        this.accomName = reservation.getRoom().getAccommodation().getAccomName();
        this.accomRegion = reservation.getRoom().getAccommodation().getRegion().getRegion().getValue();
        this.orderDate = LocalDate.now().toString();
        this.usePeriod = String.valueOf(period.getDays());
        this.startDate = reservation.getReserveUseStartDate().toString();
        this.endDate = reservation.getReserveUseEndDate().toString();
        this.startWeek = startDay;
        this.endWeek = endDay;
        this.price = String.valueOf(reservation.getReservePrice());
        this.usedStatus = reservation.getReserveStatus().toString();
        this.roomName = reservation.getRoom().getRoomName();
        this.checkIn = reservation.getRoom().getAccommodation().getCheckIn().toString();
        this.checkOut = reservation.getRoom().getAccommodation().getCheckOut().toString();
    }
    
/** 중복 발생해서 우선 주석처리 **/
//    public OrdersDetailDTO(Cart cart) {
//
//        Period period = Period.between(cart.getReserveUseStartDate(), cart.getReserveUseEndDate());
//        DayOfWeek startday = cart.getReserveUseStartDate().getDayOfWeek();
//        DayOfWeek endday = cart.getReserveUseEndDate().getDayOfWeek();
//
//        this.accomType = cart.getRoom().getAccommodation().getAccomCategory().getValue();
//        this.accomName = cart.getRoom().getAccommodation().getAccomName();
//        this.accomRegion = cart.getRoom().getAccommodation().getRegion().getRegion().getValue();
//        this.orderDate = LocalDate.now().toString();
//        this.usePeriod = String.valueOf(period.getDays());
//        this.startDate = cart.getReserveUseStartDate().toString();
//        this.endDate = cart.getReserveUseEndDate().toString();
//        this.startWeek = startday.toString();
//        this.endWeek = endday.toString();
//        this.price = String.valueOf(cart.getReservePrice());
//        this.usedStatus = cart.getReserveStatus().toString();
//        this.roomName = cart.getRoom().getRoomName();
//        this.checkIn = cart.getRoom().getAccommodation().getCheckIn().toString();
//        this.checkOut = cart.getRoom().getAccommodation().getCheckOut().toString();
//    }
}

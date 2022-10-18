
/**
 * 결제가 완료되면 cart의 내용을 저장할 테이블
 *
 */


package com.phoenix.howabouttoday.payment.entity;

import com.phoenix.howabouttoday.payment.dto.OrdersDetailDto;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Cart;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Reservation;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.util.Locale;

@DiscriminatorValue("orderDetail")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Entity
public class OrdersDetail extends Reservation {

    public OrdersDetail(Cart cart) {
    }

    public OrdersDetailDto transDto(){

        Period period = Period.between(this.getReserveUseStartDate(), this.getReserveUseEndDate());
        String checkIn = this.getRoom().getAccommodation().getCheckIn().toString();
        String checkOut = this.getRoom().getAccommodation().getCheckOut().toString();

        // 2. DayOfWeek 객체 구하기
        DayOfWeek startday = this.getReserveUseStartDate().getDayOfWeek();
        DayOfWeek endday = this.getReserveUseEndDate().getDayOfWeek();

        String startWeek = startday.getDisplayName(TextStyle.NARROW, Locale.KOREAN);  // 토
        String endWeek = endday.getDisplayName(TextStyle.SHORT, Locale.KOREAN);  // 토

        NumberFormat numberFormat = NumberFormat.getInstance();
        String price = numberFormat.format(this.getReservePrice());

        return OrdersDetailDto.builder()
                .accomType(this.getAccommodation().getAccomCategory().getValue())
                .accomName(this.getAccommodation().getAccomName())
                .accomRegion(this.getAccommodation().getRegion().getRegion().getValue())
                .orderDate(LocalDate.now().toString())
                .usePeriod(String.valueOf(period.getDays()))
                .startDate(this.getReserveUseStartDate().toString())
                .endDate(this.getReserveUseEndDate().toString())
                .startWeek(startWeek)
                .endWeek(endWeek)
                .price(price)
                .usedStatus(this.getReserveStatus().toString())
                .roomName(this.getRoom().getRoomName())
                .checkIn(checkIn)
                .checkOut(checkOut)
                .build();
    }
}

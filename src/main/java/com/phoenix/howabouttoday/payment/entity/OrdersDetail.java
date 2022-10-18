
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
        super(cart.getMember(), cart.getRoom().getAccommodation(), cart.getRoom(), cart.getOrders(), cart.getReserveStatus(), cart.getReserveUseStartDate(), cart.getReserveUseEndDate(), cart.getReservePrice(), cart.getReserveAdultCount(), cart.getReserveChildCount());

    }
}

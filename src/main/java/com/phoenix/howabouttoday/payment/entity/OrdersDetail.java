package com.phoenix.howabouttoday.payment.entity;

import com.phoenix.howabouttoday.reserve.domain.Reservation.Reservation;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@DiscriminatorValue("orderDetail")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Entity
public class OrdersDetail extends Reservation {

}

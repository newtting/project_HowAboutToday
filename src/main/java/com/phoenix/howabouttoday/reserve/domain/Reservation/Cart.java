package com.phoenix.howabouttoday.reserve.domain.Reservation;

import com.phoenix.howabouttoday.reserve.domain.Reservation.Reservation;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("cart")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
public class Cart extends Reservation {

}

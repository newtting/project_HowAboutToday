package com.phoenix.howabouttoday.reserve.domain.Reservation;

import com.phoenix.howabouttoday.accom.entity.Accommodation;
import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.payment.Orders;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Reservation;
import com.phoenix.howabouttoday.room.entity.Room;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("cart")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
@SuperBuilder
public class Cart extends Reservation {

}

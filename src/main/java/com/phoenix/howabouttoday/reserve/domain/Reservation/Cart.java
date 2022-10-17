package com.phoenix.howabouttoday.reserve.domain.Reservation;

import com.phoenix.howabouttoday.payment.dto.OrderDto;
import lombok.*;
import lombok.experimental.SuperBuilder;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;


@DiscriminatorValue("cart")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Entity
public class Cart extends Reservation {

    // @Builder
    // public Cart(Long reserveNum, Member member, Accommodation accommodation, Room room, Orders orders, ReserveStatus reserveStatus, LocalDate reserveUseStartDate, LocalDate reserveUseEndDate, int reservePrice, int reserveAdultCount, int reserveChildCount) {
    //     super(reserveNum, member, accommodation, room, orders, reserveStatus, reserveUseStartDate, reserveUseEndDate, reservePrice, reserveAdultCount, reserveChildCount);
    // }

    public OrderDto transDto(){
        return OrderDto.builder()
                .accomType(this.getAccommodation().getAccomCategory().getValue())
                .accomName(this.getAccommodation().getAccomName())
                .accomRegion(this.getAccommodation().getRegion().getRegion().getValue())
                .orderDate(LocalDate.now().toString())
                .usePeriod(this.getReserveUseStartDate().toString() + " ~ " + this.getReserveUseEndDate().toString())
                .price(String.valueOf(this.getReservePrice()))
                .usedStatus(this.getReserveStatus().toString())
                .roomName(this.getRoom().getRoomName())
                .checkTime("입실: 오후 15시, 퇴실: 오전 11시")
                .build();
    }


}

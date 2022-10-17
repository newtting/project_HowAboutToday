package com.phoenix.howabouttoday.reserve.service;

import com.phoenix.howabouttoday.reserve.domain.Reservation.Cart;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

public class CartDto {

    @Data
    public static class RequestDto{
        private Long cartNum;
        private Long memberNum;
        private Long roomNum;
        private LocalDateTime reserveUseStartDate;
        private LocalDateTime reserveUseEndDate;

        private int reservePrice;
        private int reserveAdultCount;
        private int reserveChildCount;

    }

    @Data
    public static class ResponseDto{

        private Long cartNum;
        private Long memberNum;
        private Long roomNum;

        /** 장바구니에서 보여줄 것 **/
        private String roomName;
        private String roomFileName;

        private LocalDateTime reserveUseStartDate;
        private LocalDateTime reserveUseEndDate;

        private int reservePrice;
        private int reserveAdultCount;
        private int reserveChildCount;

        public ResponseDto(Cart cart) {
            this.cartNum = cart.getReserveNum();
            this.memberNum = cart.getMember().getMemberNum();
            this.roomNum = cart.getRoom().getRoomNum();
            this.roomName = cart.getRoom().getRoomName();
//            this.roomFileName = cart.getRoom() 룸쪽에서 이미지에 대한 양방향 매핑이 필요해보임
            this.reserveUseStartDate = cart.getReserveUseStartDate();
            this.reserveUseEndDate = cart.getReserveUseEndDate();
            this.reservePrice = cart.getReservePrice();
            this.reserveAdultCount = cart.getReserveAdultCount();
            this.reserveChildCount = cart.getReserveChildCount();
        }
    }
}

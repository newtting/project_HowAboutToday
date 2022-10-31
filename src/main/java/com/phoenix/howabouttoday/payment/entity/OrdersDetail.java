
/**
 * 결제가 완료되면 cart의 내용을 저장할 테이블
 * 사실 카트와 다른 부분은 거의 없지만, dType을 사용하려면 이렇게 사용해야한다.
 */


/**
select room_num from reservation where orders_num in(select o.orders_num from member m inner join orders o on m.member_num = o.member_num and m.member_num = 1) and room_num = 1; 
select room_num from reservation where orders_num in(select o.orders_num from member m inner join orders o on m.member_num = o.member_num and m.member_num = 1) and room_num = 1; 

-- 이게 내가 생각한 쿼리. 조금 더 수정해야함 
select * from reservation where orders_num in(select o.orders_num from member m inner join orders o on m.member_num = o.member_num and m.member_num = 1) and room_num = 1;

select o.orders_num from member m inner join orders o on m.member_num = o.member_num and m.member_num = 1;
select o.orders_num from member m inner join orders o on m.member_num = o.member_num and m.member_num = 1;
*/




package com.phoenix.howabouttoday.payment.entity;

import com.phoenix.howabouttoday.accom.entity.Accommodation;
import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Cart;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Reservation;
import com.phoenix.howabouttoday.reserve.domain.Reservation.ReserveStatus;
import com.phoenix.howabouttoday.room.entity.Room;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@DiscriminatorValue("orderDetail")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Entity
public class OrdersDetail extends Reservation {

    public OrdersDetail(Boolean isReviewWrited) {
        this.isReviewWrited = isReviewWrited;
    }

    public OrdersDetail(ReservationBuilder<?, ?> b, Boolean isReviewWrited) {
        super(b);
        this.isReviewWrited = isReviewWrited;
    }

    public OrdersDetail(Long reserveNum, Member member, Accommodation accommodation, Room room, Orders orders, ReserveStatus reserveStatus, LocalDate reserveUseStartDate, LocalDate reserveUseEndDate, Integer reservePrice, Integer reserveAdultCount, Integer reserveChildCount, Boolean isReviewWrited) {
        super(reserveNum, member, accommodation, room, orders, reserveStatus, reserveUseStartDate, reserveUseEndDate, reservePrice, reserveAdultCount, reserveChildCount);
        this.isReviewWrited = isReviewWrited;
    }

    @Column
    private Boolean isReviewWrited = false;

    private void writeReview(){
        this.isReviewWrited = true;
    }


}

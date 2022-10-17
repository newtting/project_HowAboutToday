package com.phoenix.howabouttoday.reserve.domain;

import com.phoenix.howabouttoday.reserve.domain.Reservation.Cart;
import com.phoenix.howabouttoday.reserve.domain.Reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {

    List<Cart> findAllByMember(Long memberId);

    List<Cart> findAllByMember_MemberNum(Long memberId);

}

package com.phoenix.howabouttoday.payment.testDriver;

import com.phoenix.howabouttoday.reserve.domain.Reservation.Cart;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {


}

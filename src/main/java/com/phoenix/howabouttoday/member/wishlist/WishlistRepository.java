package com.phoenix.howabouttoday.member.wishlist;

import com.phoenix.howabouttoday.payment.controller.member.wishlist.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<WishList,Long> {
}
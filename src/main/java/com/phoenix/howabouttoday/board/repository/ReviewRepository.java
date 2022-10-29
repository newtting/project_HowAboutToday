package com.phoenix.howabouttoday.board.repository;

import com.phoenix.howabouttoday.room.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}

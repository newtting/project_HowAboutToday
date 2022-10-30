package com.phoenix.howabouttoday.room.repository;

import com.phoenix.howabouttoday.room.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findAllByRoom_RoomNum(Long roomNum);

}

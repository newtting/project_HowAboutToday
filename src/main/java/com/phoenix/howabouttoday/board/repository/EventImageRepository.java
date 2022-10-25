package com.phoenix.howabouttoday.board.repository;

import com.phoenix.howabouttoday.board.entity.EventImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface EventImageRepository extends JpaRepository<EventImage, Long> {

    List<EventImage> findByEventImageNum(Long eventImageNum);

}
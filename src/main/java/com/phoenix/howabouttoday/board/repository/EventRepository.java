package com.phoenix.howabouttoday.board.repository;

import com.phoenix.howabouttoday.board.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
package com.phoenix.howabouttoday.room.repository;

import com.phoenix.howabouttoday.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Override
    <S extends Room> S save(S entity);

    @Override
    List<Room> findAll();

    
}
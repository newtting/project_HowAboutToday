package com.phoenix.howabouttoday.board.repository;

import com.phoenix.howabouttoday.board.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    // Event 게시판 디테일
    Optional<Event> findByEventNum(Long eventNum);

    // Event 게시판 사진
    @Query(value = "select b.* from board b join board_category c " +
            "on b.board_category_num = c.board_category_num where c.board_category_name = ?1", nativeQuery = true)
    List<Event> findAllByCategoryName(String boardCategoryName); // 게시글 카테고리 이름 찾기

}
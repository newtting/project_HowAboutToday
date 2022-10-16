package com.phoenix.howabouttoday.board.repository;

import com.phoenix.howabouttoday.board.entity.BoardCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCategoryRepository extends JpaRepository<BoardCategory, Long> {

    public BoardCategory findByBoardCategoryName(String boardCategoryName); // 게시글 카테고리 이름 찾기

}
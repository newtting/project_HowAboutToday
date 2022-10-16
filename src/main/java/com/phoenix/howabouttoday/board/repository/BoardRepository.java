package com.phoenix.howabouttoday.board.repository;

import com.phoenix.howabouttoday.board.entity.Board;
import com.phoenix.howabouttoday.board.entity.BoardCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    public List<Board> findByBoardCategory(BoardCategory boardCategory); // 게시글 카테고리 찾기

}
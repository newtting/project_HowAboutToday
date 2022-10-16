package com.phoenix.howabouttoday.board.service;

import com.phoenix.howabouttoday.board.entity.Board;
import com.phoenix.howabouttoday.board.entity.BoardCategory;

import java.util.List;

public interface BoardService {

    public List<Board> findByCategory(BoardCategory boardCategory); // 게시판 카테고리
    public List<Board> findAll(); // 게시판 리스트
    public Board findOne(Long boardNum); // 게시판 디테일

}

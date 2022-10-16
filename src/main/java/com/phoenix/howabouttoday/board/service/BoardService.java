package com.phoenix.howabouttoday.board.service;

import com.phoenix.howabouttoday.board.dto.BoardDetailDTO;
import com.phoenix.howabouttoday.board.dto.BoardListDTO;
import com.phoenix.howabouttoday.board.dto.EventDetailDTO;
import com.phoenix.howabouttoday.board.dto.EventListDTO;
import com.phoenix.howabouttoday.board.entity.BoardCategory;

import java.util.List;

public interface BoardService {

    List<BoardListDTO> findByCategory(BoardCategory boardCategory); // 게시판 카테고리

    List<BoardListDTO> findAll_Board(String boardCategoryName); // (Notice, About Us) 게시판 리스트
    List<EventListDTO> findAll_Event(); // Event 게시판 리스트

    BoardDetailDTO findOne_Board(Long boardNum); // (Notice, FAQ, About Us) 게시판 디테일
    EventDetailDTO findOne_Event(Long eventNum); // Event 게시판 디테일

}

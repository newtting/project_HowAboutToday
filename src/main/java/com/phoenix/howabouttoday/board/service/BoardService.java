package com.phoenix.howabouttoday.board.service;

import com.phoenix.howabouttoday.board.dto.*;
import com.phoenix.howabouttoday.board.entity.EventImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {

    List<BoardListDTO> findAll_Board(String boardCategoryName); // (Notice, About Us) 게시판 리스트
    List<EventListDTO> findAll_Event(); // Event 게시판 리스트
    List<List<BoardDetailDTO>> findAll_FAQ(String boardCategoryName); // FAQ 게시판 리스트

    BoardDetailDTO findOne_Board(Long boardNum); // (Notice, About Us) 게시판 디테일
    EventDetailDTO findOne_Event(Long eventNum); // Event 게시판 디테일

    void addBoard(BoardAddDTO boardAddDTO); // (Notice, About Us) 게시판 작성
    void addEvent(EventAddDTO eventAddDTO, List<MultipartFile> eventImageList) throws Exception; // Event 게시판 작성
    void addFAQ(FAQAddDTO faqAddDTO); // FAQ 게시판 작성

    List<EventImage> addImage(Long eventNum, List<MultipartFile> multipartFiles) throws Exception; // Event 게시판 이미지 첨부
    String addImagePath(MultipartFile multipartFile) throws Exception;

}

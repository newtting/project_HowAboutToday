package com.phoenix.howabouttoday.board.controller;

import com.phoenix.howabouttoday.board.dto.BoardListDTO;
import com.phoenix.howabouttoday.board.dto.EventListDTO;
import com.phoenix.howabouttoday.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 공지사항 리스트 페이지
    @GetMapping("notice")
    public String noticeList(Model model){

        List<BoardListDTO> boardList = boardService.findAll_Board("공지사항"); // boardCategoryName = "공지사항"인 데이터들을 DTO에 저장
        model.addAttribute("lists", boardList);

        return "board/board";
    }

    // 공지사항 디테일 페이지
    @GetMapping("notice/{boardNum}")
    public String noticeDetail(){
        return "board/board";
    }

    // 이벤트 리스트 페이지
    @GetMapping("event")
    public String eventList(Model model){

        List<EventListDTO> eventList = boardService.findAll_Event();
        model.addAttribute("lists", eventList);

        return "board/board";
    }

    // 이벤트 디테일 페이지
    @GetMapping("event-details")
    public String getEventDetails(){
        return "board/board-details";
    }

    // FAQ 디테일 페이지
    @GetMapping("faq")
    public String faqList(Model model){

        List<BoardListDTO> boardList = boardService.findAll_Board("FAQ");
        model.addAttribute("lists", boardList);

        return "board/faq";
    }

    // 고객센터
    @GetMapping("contact")
    public String getContact(){
        return "board/contact";
    }
    @PostMapping("contact")
    public String postContact(){
        return "board/contact";
    }

    // 오늘어때 정보 리스트 페이지
    @GetMapping("aboutUs")
    public String aboutList(Model model){

        List<BoardListDTO> boardList = boardService.findAll_Board("오늘어때 정보"); // boardCategoryName = "오늘어때 정보"인 데이터들을 DTO에 저장
        model.addAttribute("lists", boardList);

        return "board/aboutUs";
    }

    // 오늘어때 정보 디테일 페이지
    @GetMapping("about-details")
    public String aboutDetails(){
        return "board/board-details";
    }

}

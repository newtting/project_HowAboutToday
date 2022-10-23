//package com.phoenix.howabouttoday.board.controller;
//
//import com.phoenix.howabouttoday.board.dto.*;
//import com.phoenix.howabouttoday.board.service.BoardService;
//import com.phoenix.howabouttoday.config.auth.LoginUser;
//import com.phoenix.howabouttoday.member.dto.SessionDTO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class BoardController {
//
//    private final BoardService boardService;
//
//    // 공지사항 리스트 페이지
//    @GetMapping("notice")
//    public String noticeList(@LoginUser SessionDTO sessionDTO, Model model){
//
//        if(sessionDTO != null) {
//            model.addAttribute("sessionDTO", sessionDTO);
//        }
//
//        List<BoardListDTO> boardList = boardService.findAll_Board("공지사항"); // boardCategoryName = "공지사항"인 데이터들을 DTO에 저장
//        model.addAttribute("lists", boardList);
//
//        return "board/board";
//    }
//
//    // 공지사항 디테일 페이지
//    @GetMapping("notice/{boardNum}")
//    public String noticeDetails(@LoginUser SessionDTO sessionDTO, @PathVariable Long boardNum, Model model){
//
//        if(sessionDTO != null) {
//            model.addAttribute("sessionDTO", sessionDTO);
//        }
//
//        BoardDetailDTO boardDetailDTO = boardService.findOne_Board(boardNum);
//        model.addAttribute("boardDetailDTO", boardDetailDTO);
//
//        return "board/notice-details";
//    }
//
//    // 공지사항 작성 페이지
//    @GetMapping("notice-add")
//    public String noticeAdd(@ModelAttribute("boardAddDTO") BoardAddDTO boardAddDTO,
//                            @LoginUser SessionDTO sessionDTO, Model model){
//
//        boardAddDTO.setMemberNum(sessionDTO.getMemberNum());
//        model.addAttribute("sessionDTO", sessionDTO);
//
//        return "board/notice-add";
//    }
//
//    // 공지사항 작성
//    @PostMapping("notice-add")
//    public String noticeAdd(@Valid BoardAddDTO boardAddDTO, BindingResult bindingResult,
//                            @LoginUser SessionDTO sessionDTO, Model model){
//
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("sessionDTO", sessionDTO);
//            return "board/notice-add";
//        }
//
//        boardAddDTO.setBoardCategoryNum(1L);
//        boardService.addBoard(boardAddDTO);
//
//        return "redirect:/notice";
//    }
//
//
//    // 이벤트 리스트 페이지
//    @GetMapping("event")
//    public String eventList(@LoginUser SessionDTO sessionDTO, Model model){
//
//        if(sessionDTO != null) {
//            model.addAttribute("sessionDTO", sessionDTO);
//        }
//
//        List<EventListDTO> eventList = boardService.findAll_Event();
//        model.addAttribute("lists", eventList);
//
//        return "board/board";
//    }
//
//    // 이벤트 디테일 페이지
//    @GetMapping("event/{eventNum}")
//    public String eventDetails(@LoginUser SessionDTO sessionDTO, @PathVariable Long eventNum, Model model){
//
//        if(sessionDTO != null) {
//            model.addAttribute("sessionDTO", sessionDTO);
//        }
//
//        EventDetailDTO eventDetailDTO = boardService.findOne_Event(eventNum);
//        model.addAttribute("eventDetailDTO", eventDetailDTO);
//
//        return "board/event-details";
//    }
//
//    // 이벤트 작성 페이지
//    @GetMapping("event-add")
//    public String eventAdd(@ModelAttribute("eventAddDTO") EventAddDTO eventAddDTO,
//                           @LoginUser SessionDTO sessionDTO, Model model){
//
//        eventAddDTO.setMemberNum(sessionDTO.getMemberNum());
//        model.addAttribute("sessionDTO", sessionDTO);
//
//        return "board/event-add";
//    }
//
//    // 이벤트 작성
//    @PostMapping("event-add")
//    public String eventAdd(@Valid EventAddDTO eventAddDTO, BindingResult bindingResult,
//                           @LoginUser SessionDTO sessionDTO, Model model){
//
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("sessionDTO", sessionDTO);
//            return "board/event-add";
//        }
//
//        boardService.addEvent(eventAddDTO);
//
//        return "redirect:/event";
//    }
//
//
//    // FAQ 리스트 페이지
//    @GetMapping("faq")
//    public String faqList(@LoginUser SessionDTO sessionDTO, Model model){
//
//        if(sessionDTO != null) {
//            model.addAttribute("sessionDTO", sessionDTO);
//        }
//
//        List<List<BoardDetailDTO>> faqList = boardService.findAll_FAQ("FAQ"); // boardCategoryName = "FAQ"인 데이터들을 DTO에 저장
//        model.addAttribute("lists", faqList);
//
//        return "board/faq";
//    }
//
//    // FAQ 작성 페이지
//    @GetMapping("faq-add")
//    public String faqAdd(@ModelAttribute("faqAddDTO") FAQAddDTO faqAddDTO,
//                         @LoginUser SessionDTO sessionDTO, Model model){
//
//        faqAddDTO.setMemberNum(sessionDTO.getMemberNum());
//        model.addAttribute("sessionDTO", sessionDTO);
//
//        return "board/faq-add";
//    }
//
//    // FAQ 작성
//    @PostMapping("faq-add")
//    public String faqAdd(@Valid FAQAddDTO faqAddDTO, BindingResult bindingResult,
//                         @LoginUser SessionDTO sessionDTO, Model model){
//
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("sessionDTO", sessionDTO);
//            return "board/faq-add";
//        }
//
//        boardService.addFAQ(faqAddDTO);
//
//        return "redirect:/faq";
//    }
//
//
//    // 고객센터
//    @GetMapping("contact")
//    public String getContact(@LoginUser SessionDTO sessionDTO, Model model){
//
//        if(sessionDTO != null) {
//            model.addAttribute("sessionDTO", sessionDTO);
//        }
//
//        return "board/contact";
//    }
//    @PostMapping("contact")
//    public String postContact(){
//        return "board/contact";
//    }
//
//
//    // 오늘어때 정보 리스트 페이지
//    @GetMapping("aboutUs")
//    public String aboutUsList(@LoginUser SessionDTO sessionDTO, Model model){
//
//        if(sessionDTO != null) {
//            model.addAttribute("sessionDTO", sessionDTO);
//        }
//
//        List<BoardListDTO> boardList = boardService.findAll_Board("오늘어때 정보"); // boardCategoryName = "오늘어때 정보"인 데이터들을 DTO에 저장
//        model.addAttribute("lists", boardList);
//
//        return "board/aboutUs";
//    }
//
//    // 오늘어때 정보 디테일 페이지
//    @GetMapping("aboutUs/{boardNum}")
//    public String aboutUsDetails(@LoginUser SessionDTO sessionDTO, @PathVariable Long boardNum, Model model){
//
//        if(sessionDTO != null) {
//            model.addAttribute("sessionDTO", sessionDTO);
//        }
//
//        BoardDetailDTO boardDetailDTO = boardService.findOne_Board(boardNum);
//        model.addAttribute("boardDetailDTO", boardDetailDTO);
//
//        return "board/aboutUs-details";
//    }
//
//    // 오늘어때 정보 작성 페이지
//    @GetMapping("aboutUs-add")
//    public String aboutUsAdd(@ModelAttribute("boardAddDTO") BoardAddDTO boardAddDTO,
//                             @LoginUser SessionDTO sessionDTO, Model model){
//
//        boardAddDTO.setMemberNum(sessionDTO.getMemberNum());
//        model.addAttribute("sessionDTO", sessionDTO);
//
//        return "board/aboutUs-add";
//    }
//
//    // 오늘어때 정보 작성
//    @PostMapping("aboutUs-add")
//    public String aboutUsAdd(@Valid BoardAddDTO boardAddDTO, BindingResult bindingResult,
//                             @LoginUser SessionDTO sessionDTO, Model model){
//
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("sessionDTO", sessionDTO);
//            return "board/aboutUs-add";
//        }
//
//        boardAddDTO.setBoardCategoryNum(2L);
//        boardService.addBoard(boardAddDTO);
//
//        return "redirect:/aboutUs";
//    }
//
//}

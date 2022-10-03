package com.phoenix.howabouttoday.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    // 공지사항
    @GetMapping("notice")
    public String getNotice(){
        return "board/board";
    }
    @PostMapping("notice")
    public String postNotice(){
        return "board/board";
    }

    @GetMapping("notice-details")
    public String getNoticeDetails(){
        return "board/board-details";
    }
    @PostMapping("notice-details")
    public String postNoticeDetails(){
        return "board/board-details";
    }

    // 이벤트
    @GetMapping("event")
    public String getEvent(){
        return "board/board";
    }
    @PostMapping("event")
    public String postEvent(){
        return "board/board";
    }

    @GetMapping("event-details")
    public String getEventDetails(){
        return "board/board-details";
    }
    @PostMapping("event-details")
    public String postEventDetails(){
        return "board/board-details";
    }

    // 자주 묻는 질문
    @GetMapping("faq")
    public String getFaq(){
        return "board/faq";
    }
    @PostMapping("faq")
    public String postFaq(){
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

    // 오늘어때 정보
    @GetMapping("about")
    public String getAbout(){
        return "board/about";
    }
    @PostMapping("about")
    public String postAbout(){
        return "board/about";
    }

    @GetMapping("about-details")
    public String getAboutDetails(){
        return "board/board-details";
    }
    @PostMapping("about-details")
    public String postAboutDetails(){
        return "board/board-details";
    }

}

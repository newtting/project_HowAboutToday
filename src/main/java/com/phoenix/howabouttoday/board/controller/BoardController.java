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
        return "board/notice";
    }
    @PostMapping("notice")
    public String postNotice(){
        return "board/notice";
    }

    // 이벤트
    @GetMapping("event")
    public String getEvent(){
        return "board/event";
    }
    @PostMapping("event")
    public String postEvent(){
        return "board/event";
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

}

package com.phoenix.howabouttoday.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

    @RequestMapping("/check-404page")
    public String Exception(){

        return "/notUse/page-404";
    }
}

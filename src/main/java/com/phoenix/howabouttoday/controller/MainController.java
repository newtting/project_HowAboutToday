package com.phoenix.howabouttoday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequestMapping("/api")
@Controller
public class MainController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "{\"message\":\"hiReact\"}";
    }

    @RequestMapping("/")
    @ResponseBody
    public String base(){
        return "{\"message\":\"hiAPI\"}";
    }

    @RequestMapping("/bye")
    @ResponseBody
    public String goodbye(){
        return "{\"message\":\"byeBye~\"}";
    }



}

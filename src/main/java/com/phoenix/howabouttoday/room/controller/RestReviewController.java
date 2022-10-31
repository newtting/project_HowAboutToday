package com.phoenix.howabouttoday.room.controller;


import com.phoenix.howabouttoday.config.auth.LoginUser;
import com.phoenix.howabouttoday.member.Service.MemberService;
import com.phoenix.howabouttoday.member.dto.MemberDTO;
import com.phoenix.howabouttoday.member.dto.SessionDTO;
import com.phoenix.howabouttoday.payment.dto.CouponRequestDTO;
import com.phoenix.howabouttoday.payment.dto.CouponResponseDTO;
import com.phoenix.howabouttoday.payment.dto.RoomReviewCreateRequestDTO;
import com.phoenix.howabouttoday.payment.dto.RoomReviewCreateResponseDTO;
import com.phoenix.howabouttoday.payment.service.CouponService;
import com.phoenix.howabouttoday.payment.service.OrdersService;
import com.phoenix.howabouttoday.room.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/roomReview")
@RestController
public class RestReviewController {

    private final ReviewService reviewService;

    @PostMapping("/save")
    public RoomReviewCreateResponseDTO postReviewSave(Model model, @LoginUser SessionDTO sessionDTO,@RequestBody RoomReviewCreateRequestDTO roomReviewCreateRequestDTO){
        System.out.println("실행");

        RoomReviewCreateResponseDTO roomReviewCreateResponseDTO = new RoomReviewCreateResponseDTO();

        //1. 회원이 아니면
        if(sessionDTO == null){
            return roomReviewCreateResponseDTO;
        }

        //2. 객실 구매를 했는가?

        //3 객실 이용 후 14일 이내인가?


        return null;
    }

    @PatchMapping("/update/{reviewNum}")
    public String patchReviewUpdate(Model model, @LoginUser SessionDTO sessionDTO, @PathVariable(name = "reviewNum") String reviewNum){

        return null;
    }

    @DeleteMapping("/delete/{reviewNum}")
    public String postReviewDelete(Model model, @LoginUser SessionDTO sessionDTO, @PathVariable(name = "reviewNum") String reviewNum){

        return null;
    }
}
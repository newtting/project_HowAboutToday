package com.phoenix.howabouttoday.reserve.controller;

import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.member.repository.MemberRepository;
import com.phoenix.howabouttoday.reserve.service.CartService;
import com.phoenix.howabouttoday.reserve.service.ReserveForm;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/rest/cart")
@RequiredArgsConstructor
public class CartRestController {

    private final CartService cartService;
    private final MemberRepository memberRepository;//아직 회원이없어서 테스트용 회원조회에 필요
    /** 장바구니 저장 **/
    @PostMapping
    public boolean save(
                        @RequestBody CartForm cartForm
                        ){

        /**reserveForm에 cartForm을 파싱해서 넣어주는 로직 **/
        ReserveForm reserveForm = ReserveForm.builder()
                .reserveUseStartDate(StringToParseDate(cartForm.getCheck_in()))
                .reserveUseEndDate(StringToParseDate(cartForm.getCheck_out()))
                .reserveAdultCount(cartForm.getAdultQty())
                .reserveChildCount(cartForm.getChildQty())
                .build();
        /*
        세션에 저장된 회원 꺼내는 부분
         */

        /** 테스트용 회원 **/
        Member testMember = getTestMember();
        /** ----------------- **/
        Long memberNum = testMember.getMemberNum();



        if(cartService.checkCart(memberNum,3L)){
            /*cart가 존재한다면 */
            return true;
        }else{
            /* cart가 존재하지 않는다면 장바구니에 저장*/
            cartService.save(memberNum,3L,reserveForm); //임시 룸넘버를 보냈음 테스트하기위함
            return false;
        }

    }


    /** 장바구니 페이지에서 특정 객실 삭제 **/
    @DeleteMapping("/{cartNum}")
    public ResponseEntity deleteByNum(@PathVariable Long cartNum){

        System.out.println("cartNum = " + cartNum);
        cartService.deleteByNum(cartNum);

        return new ResponseEntity(HttpStatus.OK);
    }

    public Member getTestMember(){
        Optional<Member> optionalMember = memberRepository.findById(1L);
        Member findMember = optionalMember.get();
        return findMember;
    }

    /** 스트링타입을 LocalDate타입으로 파싱해주는 메서드 **/
    public LocalDate StringToParseDate(String date){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate parseDate = LocalDate.parse(date, formatter);
        return parseDate;
    }
}

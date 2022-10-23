package com.phoenix.howabouttoday.member.wishlist.controller;

import com.phoenix.howabouttoday.member.wishlist.domain.WishList;
import com.phoenix.howabouttoday.member.wishlist.domain.WishlistRepository;
import com.phoenix.howabouttoday.member.wishlist.service.PageVo;
import com.phoenix.howabouttoday.member.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user-dashboard-wishlist")
@RequiredArgsConstructor
public class WishListController {

    private final WishListService wishListService;
    private final WishlistRepository wishlistRepository;
    @GetMapping
    public String readWishList(@PageableDefault(page = 0,size = 4,sort = "reserveNum",direction = Sort.Direction.DESC)  Pageable pageable,
                               Model model) {

//        /** ======== 페이징 처리 ======== **/
//        pageNo = (pageNo == 0) ? 0 : (pageNo -1 );
//        Page<WishListDto.ResponseDto> wishPageList = wishListService.findByMemberNum(2L, pageable, pageNo);
//        PageVo pageVo = wishListService.getPageInfo(wishPageList, pageNo);

//        Page<WishListDto.ResponseDto> wishPageList = wishListService.findByMemberNum(2L,pageable);
        Page<WishList> wishPageList = wishListService.findByMemberNum(pageable,2L);

        int nowPage = wishPageList.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.max(nowPage + 5,wishPageList.getTotalPages());

        model.addAttribute("wishList",wishPageList);
        model.addAttribute("nowPage",nowPage);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage", endPage);

        return "member/userdashboard/user-dashboard-wishlist";
    }
    @PostMapping
    public String postWishList() {
        return "member/userdashboard/user-dashboard-wishlist";
    }


}

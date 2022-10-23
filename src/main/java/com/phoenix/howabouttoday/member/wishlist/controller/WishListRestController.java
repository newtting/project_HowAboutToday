package com.phoenix.howabouttoday.member.wishlist.controller;

import com.phoenix.howabouttoday.member.wishlist.domain.WishlistRepository;
import com.phoenix.howabouttoday.member.wishlist.service.WishListService;
import com.phoenix.howabouttoday.member.wishlist.service.WishListServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WishListRestController {

//    private final WishlistRepository wishlistRepository;
//    private final WishListService wishListService;
//
//    @GetMapping("/rest/wishlist")
//    public Page<WishListDto.ResponseDto> wishListTest(Pageable pageable){
//        Pageable customPageble = Pageable.ofSize(3);
//        return wishListService.findByMemberNum(2L,customPageble,1);
//    }
}

package com.phoenix.howabouttoday.member.wishlist.service;

import com.phoenix.howabouttoday.member.repository.MemberRepository;
import com.phoenix.howabouttoday.member.wishlist.controller.WishListDto;
import com.phoenix.howabouttoday.member.wishlist.domain.WishList;
import com.phoenix.howabouttoday.member.wishlist.domain.WishlistRepository;
import com.phoenix.howabouttoday.room.repository.RoomRepository;
import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class WishListServiceImpl implements WishListService{

    private static final int PAGE_WISHLIST_COUNT = 3; //한 화면에 보일 컨텐츠 수

    private final MemberRepository memberRepository;
    private final RoomRepository roomRepository;
    private final WishlistRepository wishlistRepository;

    @Override
    public Page<WishList> findByMemberNum(Pageable pageable,Long memberNum) {
        memberRepository.findById(memberNum).orElseThrow(() ->
                new IllegalArgumentException("해당 사용자가 존재하지 않습니다"));

        /* pageble 객체 반환 */
//        int page = (pageable.getPageNumber()== 0) ? 0 : (pageable.getPageNumber() -1);
//        pageable = PageRequest.of(page, 5,Sort.by(Sort.Direction.DESC,"reserveNum"));
        /*memberNum에 해당하는 페이지객체 반환 */
        Page<WishList> pageWishList = wishlistRepository.findAllByMemberMemberNum(memberNum,pageable);

        /* Dto로 변환 */
        Page<WishListDto.ResponseDto> wishListPageList = pageWishList.map(
                wishlist -> new WishListDto.ResponseDto(wishlist)
        );

        return pageWishList;

    }

    @Override
    public boolean checkHaveWish(Long memberNum) {
        return false;
    }

    @Override
    public boolean checkWish(Long memberNum, Long AccomNum) {
        return false;
    }

    @Override
    public void save(Long memberNum, Long AccomNum) {

    }

    @Override
    public void deleteByNum(Long memberNum, Long AccomNum) {

    }

    @Override
    public void deleteByWish(Long wishListNum) {

    }

//    @Override
//    public PageVo getPageInfo(Page<WishListDto.ResponseDto> wishPageList, int pageNo) {
//        int totalPage = wishPageList.getTotalPages();
//
//        // 현재 페이지를 통해 현재 페이지 그룹의 시작 페이지를 구함
//        int startNumber = (int)((Math.floor(pageNo/PAGE_WISHLIST_COUNT)*PAGE_WISHLIST_COUNT)+1 <= totalPage ? (Math.floor(pageNo/PAGE_WISHLIST_COUNT)*PAGE_WISHLIST_COUNT)+1 : totalPage);
//
//        // 전체 페이지 수와 현재 페이지 그룹의 시작 페이지를 통해 현재 페이지 그룹의 마지막 페이지를 구함
//        int endNumber = (startNumber + PAGE_WISHLIST_COUNT-1 < totalPage ? startNumber + PAGE_WISHLIST_COUNT-1 : totalPage);
//        boolean hasPrev = wishPageList.hasPrevious();
//        boolean hasNext = wishPageList.hasNext();
//
//        /* 화면에는 원래 페이지 인덱스+1 로 출력됨을 주의 */
//        int prevIndex = wishPageList.previousOrFirstPageable().getPageNumber()+1;
//        int nextIndex = wishPageList.nextOrLastPageable().getPageNumber()+1;
//
//        return new PageVo(totalPage, startNumber, endNumber, hasPrev, hasNext, prevIndex, nextIndex);
//
//    }
}
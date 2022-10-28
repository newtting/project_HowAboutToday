package com.phoenix.howabouttoday.accom.service;

import com.phoenix.howabouttoday.accom.dto.AccomCategoryDto;
import com.phoenix.howabouttoday.accom.dto.AccomReviewDTO;
import com.phoenix.howabouttoday.accom.entity.Accommodation;
import com.phoenix.howabouttoday.accom.repository.AccomReviewRepository;
import com.phoenix.howabouttoday.accom.repository.AccommodationRepository;
import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.member.repository.MemberRepository;
import com.phoenix.howabouttoday.room.entity.Review;
import com.phoenix.howabouttoday.room.entity.Room;
import com.phoenix.howabouttoday.room.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccomReviewServiceImpl implements AccomReviewService{

    private final MemberRepository memberRepository;
    private final AccomReviewRepository accomReviewRepository;
    private final AccommodationRepository accommodationRepository;

    private final RoomRepository roomRepository;

    public List<AccomReviewDTO.ResponseDto> findAllByAccom(Long review_id) {

        Room room = roomRepository.findById(review_id).orElseThrow(() ->
                                                                    new IllegalArgumentException("해당 숙소의 댓글이 존재하지 않습니다."));

        List<Review> reviewList =room.getReviews();

        return reviewList.stream().map(AccomReviewDTO.ResponseDto::new).collect(Collectors.toList());

    }
}

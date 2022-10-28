package com.phoenix.howabouttoday.accom.controller;

import com.phoenix.howabouttoday.accom.dto.AccomDto;
import com.phoenix.howabouttoday.accom.entity.Accommodation;
import com.phoenix.howabouttoday.accom.service.AccomodationService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/accom")
@RequiredArgsConstructor
public class AccomRestController {



    private final AccomodationService accomodationService;

    /** 기본 조회 컨트롤러 **/
    @GetMapping("{category_name}")
    public Slice<AccomDto.ResponsePageDto> accommodations(@PathVariable(required = false) String category_name,
                                               @PageableDefault(page = 0,size = 5,sort = "lowPrice",direction = Sort.Direction.ASC) Pageable pageable,
                                                          @RequestParam(value = "keyword",required = false) String keyword) {
        /** 검색어가 없을경우 처리 로직 **/
        if(keyword==null || keyword.equals("") ){
            keyword = "";
        }

        return accomodationService.getAccomPageList(pageable,category_name,keyword);

    }

    /** 가격 낮은순 컨트롤러 **/
    @GetMapping("/asc/{category_name}")
    public Slice<AccomDto.ResponsePageDto> ascSort(@PathVariable(required = false) String category_name,
                                                          @PageableDefault(page = 0,size = 5,sort = "lowPrice",direction = Sort.Direction.ASC) Pageable pageable,
                                                   @RequestParam(value = "keyword",required = false) String keyword) {
        /** 검색어가 없을경우 처리 로직 **/
        if(keyword==null || keyword.equals("") ){
            keyword = "";
        }

        return accomodationService.getAccomPageList(pageable,category_name,keyword);

    }

    /** 가격 높은순 컨트롤러 **/
    @GetMapping("/desc/{category_name}")
    public Slice<AccomDto.ResponsePageDto> descSort(@PathVariable(required = false) String category_name,
                                                   @PageableDefault(page = 0,size = 5,sort = "lowPrice",direction = Sort.Direction.DESC) Pageable pageable,
                                                    @RequestParam(value = "keyword",required = false) String keyword) {

        /** 검색어가 없을경우 처리 로직 **/
        if(keyword==null || keyword.equals("") ){
            keyword = "";
        }

        return accomodationService.getAccomPageList(pageable,category_name,keyword);

    }


}

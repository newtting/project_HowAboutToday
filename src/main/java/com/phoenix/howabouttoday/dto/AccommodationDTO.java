package com.phoenix.howabouttoday.dto;

public class AccommodationDTO {

    private int accomNum;//숙소 번호
    private String accomName;//숙소 이름
    private String accomTel;//숙소 전화번호
    private int accomCategoryNum;//숙소 카테고리 번호
    private String accomCategoryName;//숙소 카테고리 이름
    private int regionNum;//숙소 지역 번호
    private String regionName;//숙소 지역 이름
    private int regionParentNum;//숙소 지역 Parent 번호
    private String accomAddress;//숙소 주소
    private Double accomRating;//숙소 평점
    private int accomRatingCount;
    private Double latitude;//위도
    private Double longitude;//경도
    private int lowPrice;//한 숙소의 객실 최저가
    private int reserveRange;//예약 가능일 범위(ex. 60 → 오늘부터 +60일까지 예약 가능)
    private String accomOriginFileName;//숙소 이미지 기존 파일 이름
    private String accomSaveFileName;//숙소 이미지 저장 파일 이름

}

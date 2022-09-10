package com.phoenix.howabouttoday.dto;

public class RoomDTO {

    private int roomNum;//객실 번호
    private String roomName;//객실 이름
    private int defaultGuest;//최소 인원
    private int maxGuest;//최대 인원
    private String stayStartDate;//객실 이용 시작일
    private String stayEndDate;//객실 이용 종료일
    private int weekdayPrice;//평일 숙소 금액
    private int weekdayDiscount;//평일 할인 금액
    private int weekendPrice;//주말 숙소 금액
    private int weekendDiscount;//주말 할인 금액
    private String restStartTime;//대실 시작 시간
    private String restEndTime;//대실 종료 시간
    private String roomInfo;//객실 정보
    private String roomOriginFileName;//객실 이미지 기존 파일 이름
    private String roomSaveFileName;//객실 이미지 저장 파일 이름

}

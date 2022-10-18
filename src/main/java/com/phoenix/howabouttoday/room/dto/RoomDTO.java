package com.phoenix.howabouttoday.room.dto;

import com.phoenix.howabouttoday.room.entity.Room;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class RoomDTO {
    private Long roomNum;//객실 번호
    private String roomName;//객실 이름
    private int defaultGuest;//최소 인원
    private int maxGuest;//최대 인원
    private LocalDate stayStartDate;//객실 이용 시작일
    private LocalDate stayEndDate;//객실 이용 종료일
    private int price; //가격
    private String roomInfo;//객실 정보

    private String roomOriginFileName;//객실 이미지 기존 파일 이름
    private String roomSaveFileName;//객실 이미지 저장 파일 이름

    @Builder
    public RoomDTO(Long roomNum,String roomName,int defaultGuest,int maxGuest, LocalDate stayStartDate, LocalDate stayEndDate, int price, String roomInfo, String roomOriginFileName, String roomSaveFileName) {
        this.roomNum = roomNum;
        this.roomName = roomName;
        this.defaultGuest = defaultGuest;
        this.maxGuest = maxGuest;
        this.stayStartDate = stayStartDate;
        this.stayEndDate = stayEndDate;
        this.price = price;
        this.roomInfo = roomInfo;
        this.roomOriginFileName = roomOriginFileName;
        this.roomSaveFileName = roomSaveFileName;
    }

}

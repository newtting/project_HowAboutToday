package com.phoenix.howabouttoday.room.entity;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Data
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int roomNum;

    @NotNull
    @Column(length = 30)
    private String roomName;

    @NotNull
    private int defaultGuest;//최소 인원

    @NotNull
    private int maxGuest;//최대 인원

    @NotNull
    private String stayStartDate;//객실 이용 시작일

    @NotNull
    private String stayEndDate;//객실 이용 종료일

    @NotNull
    private int weekdayPrice;//평일 숙소 금액

    @NotNull
    private int weekdayDiscount;//평일 할인 금액

    @NotNull
    private int weekendPrice;//주말 숙소 금액

    @NotNull
    private int weekendDiscount;//주말 할인 금액

    @NotNull
    private String roomInfo;//객실 정보

    //private String restStartTime;//대실 시작 시간
    //private String restEndTime;//대실 종료 시간

    @Builder
    public Room(String roomName,int defaultGuest,int maxGuest,String stayStartDate,String stayEndDate,int weekdayPrice,int weekendPrice,int weekendDiscount,String roomInfo) {
        this.roomName = roomName;
        this.defaultGuest = defaultGuest;
        this.maxGuest = maxGuest;
        this.stayStartDate = stayStartDate;
        this.stayEndDate = stayEndDate;
        this.weekdayPrice = weekdayPrice;
        this.weekdayDiscount = weekendDiscount;
        this.weekendPrice = weekendPrice;
        this.weekendDiscount = weekendDiscount;
        this.roomInfo = roomInfo;
    }

}

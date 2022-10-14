package com.phoenix.howabouttoday.room.entity;

import com.phoenix.howabouttoday.accom.entity.Accommodation;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomNum;


    @Column(length = 30)
    private String roomName;


    @ManyToOne
    @JoinColumn(name = "accom_num")
    private Accommodation accommodation;

    private Integer defaultGuest;//최소 인원


    private Integer maxGuest;//최대 인원


    private String stayStartDate;//객실 이용 시작일


    private String stayEndDate;//객실 이용 종료일


    private Integer weekdayPrice;//평일 숙소 금액


    private Integer weekdayDiscount;//평일 할인 금액


    private Integer weekendPrice;//주말 숙소 금액


    private Integer weekendDiscount;//주말 할인 금액


    private String roomInfo;//객실 정보

    //private String restStartTime;//대실 시작 시간
    //private String restEndTime;//대실 종료 시간

    @Builder
    public Room(String roomName,int defaultGuest,int maxGuest,String stayStartDate,String stayEndDate,int weekdayPrice,int weekendPrice,int weekendDiscount,String roomInfo , Accommodation accommodation) {
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
        this.accommodation = accommodation;
    }

}

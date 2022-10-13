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
    @Column
    private Integer roomNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="accommodation_accomNum", referencedColumnName = "accomNum")
    private Accommodation accommodation;

    @NotNull
    @Column(length = 50)
    private String roomName;

    @NotNull
    private Integer defaultGuest;//최소 인원

    @NotNull
    private Integer maxGuest;//최대 인원


    @NotNull
    private Integer price;//주말 숙소 금액

    @NotNull
    private String roomInfo;//객실 정보

    //private String restStartTime;//대실 시작 시간
    //private String restEndTime;//대실 종료 시간

    @Builder
    public Room(String roomName,int defaultGuest,int maxGuest, Integer price, String roomInfo) {
        this.roomName = roomName;
        this.defaultGuest = defaultGuest;
        this.maxGuest = maxGuest;
        this.price = price;
        this.roomInfo = roomInfo;
    }

}

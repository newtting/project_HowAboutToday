package com.phoenix.howabouttoday.room.entity;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;


import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class RoomImage {
    
    //import가 import org.springframework.data.annotation.Id; 이거말고
    //import javax.persistence.*; 이걸로 되어야 기본키 에러가 안남
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long roomNum;

    @NotNull
    @Column(length = 50)
    private String roomOriginFileName;

    @NotNull
    @Column(length = 50)
    private String roomSaveFileName;

    @Builder
    public RoomImage(String roomOriginFileName,String roomSaveFileName) {
        this.roomOriginFileName = roomOriginFileName;
        this.roomSaveFileName = roomSaveFileName;
    }

}

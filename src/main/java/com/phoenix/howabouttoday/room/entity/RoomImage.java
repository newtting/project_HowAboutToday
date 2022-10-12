package com.phoenix.howabouttoday.room.entity;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int roomNum;

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

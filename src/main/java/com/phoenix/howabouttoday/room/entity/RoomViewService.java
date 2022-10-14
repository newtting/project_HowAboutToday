package com.phoenix.howabouttoday.room.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;



@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class RoomViewService {

    @Id
    private Long roomViewAmenitiesNum;

}

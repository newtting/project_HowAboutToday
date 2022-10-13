package com.phoenix.howabouttoday.room.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomViewAmenities {

    @Id
    private Integer roomViewAmenitiesNum;

}

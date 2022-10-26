package com.phoenix.howabouttoday.room.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
public class Amenities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long amenitiesNum;//시설번호

    @Column
    private String amenitiesName;//시설이름

    @Builder
    public Amenities(Long amenitiesNum, String amenitiesName) {
        this.amenitiesNum = amenitiesNum;
        this.amenitiesName = amenitiesName;
    }


}

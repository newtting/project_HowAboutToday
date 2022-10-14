package com.phoenix.howabouttoday.accom.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
public class Facilties {

    @Id
    @GeneratedValue
    @Column
    private Long faciltiesNum;//시설번호

    @Enumerated(EnumType.STRING)
    private FaciltiesName faciltiesName;//시설이름

    private String faciltiesOriginalFileName;
    private String faciltiesSaveFilename;
}

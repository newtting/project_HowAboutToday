package com.phoenix.howabouttoday.accom.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table
public class AccomViewFacilties {

    @Id @GeneratedValue
    private Long accomViewfaciltiesNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accom_num")
    private Accommodation accommodation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facilties_num")
    private Facilties facilties;







}


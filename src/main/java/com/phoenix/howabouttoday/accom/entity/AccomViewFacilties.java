package com.phoenix.howabouttoday.accom.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="T_ACCOM_VIEW_FACILITES")
public class AccomViewFacilties {

    @Id @GeneratedValue
    private Long accomViewfaciltiesNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_num")
    private Accommodation accommodation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facilties_num")
    private Facilties facilties;







}


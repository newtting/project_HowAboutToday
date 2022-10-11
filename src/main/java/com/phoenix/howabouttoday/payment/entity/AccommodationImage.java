package com.phoenix.howabouttoday.payment.entity;


import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccommodationImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long accomNum;

//    @ManyToOne(targetEntity = Accommodation.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "t_accommodation_accomnum")
//    private Accommodation acconum;

    @NotNull
    @Column(length = 100)
    private String accomOriginFilename;


    @NotNull
    @Column(length = 100)
    private String accomSaveFilename;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="accommodation_accomNum", referencedColumnName = "accomNum")
    private Accommodation accommodation;

    @Builder
    public AccommodationImage(String accomOriginFilename, String accomSaveFilename, Accommodation accommodation) {
        this.accomOriginFilename = accomOriginFilename;
        this.accomSaveFilename = accomSaveFilename;
        this.accommodation = accommodation;
    }
}



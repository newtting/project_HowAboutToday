package com.phoenix.howabouttoday.payment.entity;


import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long accomNum;

    @NotNull
    @Column(length = 50)
    private String accomName;


    @NotNull
    @Column(length = 50)
    private String accomTel;

    @NotNull
//    @OneToMany() 추후에 숙소카테고리 만든 후 entity 만든 후에 매핑하자
    private Integer accomCategoryNum;

    @NotNull
    //    @OneToMany() 추후에 지역 카테고리 entity 만든 후에 매핑하자
    private Integer regionNum ;

    @NotNull
    @Column(length = 200)
    private String accomAddress ;

    @NotNull
    @Column(precision = 1, scale = 2)
    private Double accomRating ;

    @NotNull
    private Integer accomWishlistCount;

    @NotNull
    private Integer totalReviewNum ;

    @NotNull
    @Column(precision = 14, scale = 28)
    private Double latitude ;

    @NotNull
    @Column(precision = 14, scale = 31)
    private Double longitude ;

    @NotNull
    private Integer lowPrice ;

    @NotNull
    private Integer reserveRange ;

    //양방향 매핑을 위해 추가
    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL)
    private List<AccommodationImage> accommodationImage;

    @Builder
    public Accommodation(String accomName, String accomTel, Integer accomCategoryNum, Integer regionNum, String accomAddress, Double accomRating, Integer accomWishlistCount, Integer totalReviewNum, Double latitude, Double longitude, Integer lowPrice, Integer reserveRange, List<AccommodationImage> accommodationImage) {
        this.accomName = accomName;
        this.accomTel = accomTel;
        this.accomCategoryNum = accomCategoryNum;
        this.regionNum = regionNum;
        this.accomAddress = accomAddress;
        this.accomRating = accomRating;
        this.accomWishlistCount = accomWishlistCount;
        this.totalReviewNum = totalReviewNum;
        this.latitude = latitude;
        this.longitude = longitude;
        this.lowPrice = lowPrice;
        this.reserveRange = reserveRange;
        this.accommodationImage = accommodationImage;
    }
}

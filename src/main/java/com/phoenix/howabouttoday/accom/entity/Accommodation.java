package com.phoenix.howabouttoday.accom.entity;


import com.phoenix.howabouttoday.payment.AccomCategory;
import com.phoenix.howabouttoday.payment.AccomCategoryConverter;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long accomNum;  //숙소 번호


    @Column(length = 50)
    private String accomName;//숙소 이름


    @Column(length = 50)
    private String accomTel;//숙소 전화번호


    @Column(length = 50)
    @Convert(converter = AccomCategoryConverter.class)
    private AccomCategory accomCategoryName;//숙소 카테고리 번호


    //    @OneToMany() 추후에 지역 카테고리 entity 만든 후에 매핑필요

    @ManyToOne
    @JoinColumn(name = "region_num")
    private Region region; //숙소 지역 번호


    @Column(length = 200)
    private String accomAddress;//숙소 주소


    @Column(precision = 1, scale = 2)
    private Double accomRating;//숙소 평점


    private Integer totalReviewNum;//숙소의 평점 수


    private Integer accomWishlistCount; //즐겨찾기 버튼 갯수


    @Column(precision = 14, scale = 28)
    private Double latitude; //위도


    @Column(precision = 14, scale = 31)
    private Double longitude; //경도


    private Integer lowPrice; //숙소의 객실 최저가


    private Integer reserveRange;//예약 가능일 범위(ex. 60 → 오늘부터 +60일까지 예약 가능)

    //양방향 매핑을 위해 추가
    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.ALL)
    private List<AccomImage> accommodationImage;    //이미지 fk를 위한 매핑

    @Builder
    public Accommodation(String accomName, String accomTel, AccomCategory accomCategoryName, Region region, String accomAddress, Double accomRating, Integer accomWishlistCount, Integer totalReviewNum, Double latitude, Double longitude, Integer lowPrice, Integer reserveRange, List<AccomImage> accommodationImage) {
        this.accomName = accomName;
        this.accomTel = accomTel;
        this.accomCategoryName = accomCategoryName;
        this.region = region;
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

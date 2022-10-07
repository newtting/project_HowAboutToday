package com.phoenix.howabouttoday.payment.entity;


import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "t_accommodation")
public class Accommodation {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "accomNum")
    private Long accomnum;

    @NotNull
    @Column(length = 50)
    private String accomname;


    @NotNull
    @Column(length = 50)
    private String accomtel;

    @NotNull
//    @OneToMany() 추후에 숙소카테고리 만든 후 entity 만든 후에 매핑하자
    private Integer accomcategorynum;

    @NotNull
    //    @OneToMany() 추후에 지역 카테고리 entity 만든 후에 매핑하자
    private Integer regionnum ;

    @NotNull
    @Column(length = 200)
    private String accomaddress ;

    @NotNull
    @Column(precision = 1, scale = 2)
    private Double accomrating ;

    @NotNull
    private Integer accomwishlistcount;

    @NotNull
    private Integer totalreviewnum ;

    @NotNull
    @Column(precision = 14, scale = 28)
    private Double latitude ;

    @NotNull
    @Column(precision = 14, scale = 31)
    private Double longitude ;

    @NotNull
    private Integer lowprice ;

    @NotNull
    private Integer reserverange ;



}

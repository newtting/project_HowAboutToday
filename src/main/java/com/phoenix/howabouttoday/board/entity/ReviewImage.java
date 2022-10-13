package com.phoenix.howabouttoday.board.entity;


import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table


public class ReviewImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int reviewNum;


    @NotNull
    @Column(length = 50)
    private String reviewOriginalFileName;

    @NotNull
    @Column(length = 50)
    private String reviewSaveFileName;

    @Builder
    public ReviewImage(String reviewOriginalFileName,String reviewSaveFileName) {
        this.reviewOriginalFileName = reviewOriginalFileName;
        this.reviewSaveFileName =reviewOriginalFileName;
    }


}

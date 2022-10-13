package com.phoenix.howabouttoday.board.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "board_image")
public class BoardImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardImageNum; // 게시글 이미지 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_num", nullable = false)
    private Board board; // 게시글

    @Column(nullable = false)
    private String boardOriginFileName; // 게시글 이미지 기존 파일 이름

    @Column(nullable = false)
    private String boardSaveFileName; // 게시글 이미지 저장 파일 이름

}

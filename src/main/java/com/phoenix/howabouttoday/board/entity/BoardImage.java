package com.phoenix.howabouttoday.board.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
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

    @Builder
    public BoardImage(String boardOriginFileName, String boardSaveFileName, Board board) {
        this.boardOriginFileName = boardOriginFileName;
        this.boardSaveFileName = boardSaveFileName;
        this.board = board;
    }

}

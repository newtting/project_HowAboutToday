package com.phoenix.howabouttoday.board.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board")
public class Board {

    // Notice, Event, FAQ, About

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNum; // 게시글 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_category_num")
    private BoardCategory boardCategory; // 게시글 카테고리

    @Column(nullable = false)
    private String boardTitle; // 게시글 제목

    @Column
    private String boardContent; // 게시글 내용

    @CreatedDate
    @Column
    private LocalDateTime boardCreate; // 게시글 작성일

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<BoardImage> boardImageList = new ArrayList<>();

    @Builder
    public Board(String boardTitle, String boardContent, LocalDateTime boardCreate,BoardCategory boardCategory) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardCreate = boardCreate;
        this.boardCategory = boardCategory;
    }

}

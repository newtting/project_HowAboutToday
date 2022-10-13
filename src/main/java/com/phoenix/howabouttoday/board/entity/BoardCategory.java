package com.phoenix.howabouttoday.board.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "board_category")
public class BoardCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardCategoryNum; // 게시글 카테고리 번호

    @Column(nullable = false)
    private String boardCategoryName; // 게시글 카테고리 이름

    @Column
    private int boardParentNum; // 게시글 카테고리 상위 번호

    @OneToMany(mappedBy = "boardCategory", cascade = CascadeType.ALL)
    private List<Board> boardList = new ArrayList<>();

    public BoardCategory(String boardCategoryName, int boardParentNum) {
        this.boardCategoryName = boardCategoryName;
        this.boardParentNum = boardParentNum;
    }
}

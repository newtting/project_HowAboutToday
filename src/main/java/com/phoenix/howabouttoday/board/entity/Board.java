package com.phoenix.howabouttoday.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Board {

    // Notice, Event, FAQ, About

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boardNum")
    private int boardNum;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "board_category", nullable = false)
//    private int boardCategoryNum;

    @Column(nullable = false)
    private String boardTitle;

    @Column(nullable = false)
    private String boardContent;

    @CreatedDate
    private LocalDateTime boardCreate;

    @Builder
    public Board(int boardCategoryNum, String boardTitle, String boardContent) {
//        this.boardCategoryNum = boardCategoryNum;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
    }

}

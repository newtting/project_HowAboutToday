package com.phoenix.howabouttoday.board;

import com.phoenix.howabouttoday.board.entity.Board;
import com.phoenix.howabouttoday.board.entity.BoardCategory;
import com.phoenix.howabouttoday.board.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void BoardList() {

        String boardTitle = "테스트 게시글";
        String boardContent = "테스트 본문";
        LocalDateTime boardCreate = LocalDateTime.of(2022,10,12,16,51);

        String boardCategoryName = "공지사항";
        int boardParentNum = 0;

        boardRepository.save(Board.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .boardCreate(boardCreate)
                .boardCategory(new BoardCategory(boardCategoryName, boardParentNum))
                .build());

        List<Board> boardList = boardRepository.findAll();

        Board board = boardList.get(0);
        assertThat(board.getBoardTitle()).isEqualTo(boardTitle);
        assertThat(board.getBoardContent()).isEqualTo(boardContent);
        assertThat(board.getBoardCreate()).isEqualTo(boardCreate);

    }

}

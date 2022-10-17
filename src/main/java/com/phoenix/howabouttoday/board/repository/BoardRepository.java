package com.phoenix.howabouttoday.board.repository;

import com.phoenix.howabouttoday.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    // (Notice, About Us) 게시판 리스트
    /*
    Table(board와 boardCategory)을 조인해서, 각각의 boardCategoryNum이 일치시키고
    Table board에서 boardCategoryName = "boardCategoryName"인 모든 데이터를 가져온다
    ?1 : Method findAllByCategoryName의 첫번째 Parameter (boardCategoryName)
     */
    @Query(value = "select b.* from board b join board_category c " +
            "on b.board_category_num = c.board_category_num where c.board_category_name = ?1", nativeQuery = true)
    List<Board> findAllByCategoryName(String boardCategoryName); // 게시글 카테고리 이름 찾기

    // (Notice, FAQ, About Us) 게시판 디테일
    Optional<Board> findByBoardNum(Long boardNum);

}
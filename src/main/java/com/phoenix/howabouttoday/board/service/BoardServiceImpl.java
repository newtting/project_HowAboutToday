package com.phoenix.howabouttoday.board.service;

import com.phoenix.howabouttoday.board.dto.BoardDetailDTO;
import com.phoenix.howabouttoday.board.dto.BoardListDTO;
import com.phoenix.howabouttoday.board.entity.Board;
import com.phoenix.howabouttoday.board.entity.BoardCategory;
import com.phoenix.howabouttoday.board.repository.BoardCategoryRepository;
import com.phoenix.howabouttoday.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final BoardCategoryRepository boardCategoryRepository;

    // 게시판 카테고리
    @Override
    public List<Board> findByCategory(BoardCategory boardCategory) {
        return boardRepository.findByBoardCategory(boardCategory);
    }

    // 게시판 리스트
    @Override
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    // 게시판 디테일
    @Override
    public Board findOne(Long boardNum) {
        return boardRepository.getReferenceById(boardNum);
    }

}

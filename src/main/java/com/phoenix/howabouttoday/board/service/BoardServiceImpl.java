package com.phoenix.howabouttoday.board.service;

import com.phoenix.howabouttoday.board.dto.BoardDetailDTO;
import com.phoenix.howabouttoday.board.dto.BoardListDTO;
import com.phoenix.howabouttoday.board.dto.EventDetailDTO;
import com.phoenix.howabouttoday.board.dto.EventListDTO;
import com.phoenix.howabouttoday.board.repository.BoardRepository;
import com.phoenix.howabouttoday.board.repository.EventRepository;
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
    private final EventRepository eventRepository;

    // (Notice, About Us) 게시판 리스트
    @Override
    public List<BoardListDTO> findAll_Board(String boardCategoryName) {

        // Entity → DTO
        List<BoardListDTO> lists = boardRepository.findAllByCategoryName(boardCategoryName) // Entity List
                .stream() // Entity Stream
                .map(BoardListDTO::new) // DTO Stream
                .collect(Collectors.toList()); // DTO List

        return lists;
    }

    // Event 게시판 리스트
    @Override
    public List<EventListDTO> findAll_Event() {

        // Entity → DTO
        List<EventListDTO> lists = eventRepository.findAll() // Entity List
                .stream() // Entity Stream
                .map(EventListDTO::new) // DTO Stream
                .collect(Collectors.toList()); // DTO List

        return lists;
    }

    // (Notice, FAQ, About Us) 게시판 디테일
    @Override
    public BoardDetailDTO findOne_Board(Long boardNum) {

        return boardRepository.findByBoardNum(boardNum) // Entity
                .map(BoardDetailDTO::new) // DTO
                .orElse(null); // 에러 시 null 반환
    }

    // Event 게시판 디테일
    @Override
    public EventDetailDTO findOne_Event(Long eventNum) {

        // Entity → DTO
        return eventRepository.findByEventNum(eventNum) // Entity
                .map(EventDetailDTO::new) // DTO
                .orElse(null); // 에러 시 null 반환
    }

}

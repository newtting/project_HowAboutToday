package com.phoenix.howabouttoday.board.service;

import com.phoenix.howabouttoday.board.dto.*;
import com.phoenix.howabouttoday.board.entity.Board;
import com.phoenix.howabouttoday.board.entity.BoardCategory;
import com.phoenix.howabouttoday.board.entity.Event;
import com.phoenix.howabouttoday.board.entity.EventImage;
import com.phoenix.howabouttoday.board.repository.BoardCategoryRepository;
import com.phoenix.howabouttoday.board.repository.BoardRepository;
import com.phoenix.howabouttoday.board.repository.EventImageRepository;
import com.phoenix.howabouttoday.board.repository.EventRepository;
import com.phoenix.howabouttoday.member.entity.Member;
import com.phoenix.howabouttoday.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final BoardCategoryRepository boardCategoryRepository;
    private final EventRepository eventRepository;
    private final EventImageRepository eventImageRepository;

    private final MemberRepository memberRepository;

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

    // FAQ 게시판 리스트
    @Override
    public List<List<BoardDetailDTO>> findAll_FAQ(String boardCategoryName) {

        List<BoardCategory> categoryList = boardCategoryRepository.findAllByCategoryName(boardCategoryName); // FAQ 관련 Category List
        List<List<BoardDetailDTO>> faqList = new ArrayList<>(); // Board Detail List

        // Board Detail List
        for(BoardCategory boardCategory : categoryList) { // Category 1개 : categoryList에서 1개씩 빼서 boardCategory에 넣는다

            // Board Detail 1개 
            // Entity → DTO
            List<BoardDetailDTO> lists = boardRepository.findAllByBoardCategory(boardCategory) // Entity List
                    .stream() // Entity Stream
                    .map(BoardDetailDTO::new) // DTO Stream
                    .collect(Collectors.toList()); // DTO List

            faqList.add(lists);
        }

        return faqList;
    }

    // (Notice, About Us) 게시판 디테일
    @Override
    public BoardDetailDTO findOne_Board(Long boardNum) {

        // Entity → DTO
        return boardRepository.findById(boardNum) // Entity
                .map(BoardDetailDTO::new) // DTO
                .orElse(null); // 에러 시 null 반환
    }

    // Event 게시판 디테일
    @Override
    public EventDetailDTO findOne_Event(Long eventNum) {

        // Entity → DTO
        return eventRepository.findById(eventNum) // Entity
                .map(EventDetailDTO::new) // DTO
                .orElse(null); // 에러 시 null 반환
    }

    // (Notice, About Us) 게시글 작성
    @Override
    @Transactional
    public void addBoard(BoardAddDTO boardAddDTO) {

        Member member = memberRepository.findById(boardAddDTO.getMemberNum()).orElse(null);
        BoardCategory boardCategory = boardCategoryRepository.findById(boardAddDTO.getBoardCategoryNum()).orElse(null);

        Board board = new Board(member, boardCategory, boardAddDTO);
        boardRepository.save(board);
    }

    // Event 게시판 작성
    @Override
    @Transactional
    public void addEvent(EventAddDTO eventAddDTO, List<MultipartFile> eventImageList) throws Exception {

        Member member = memberRepository.findById(eventAddDTO.getMemberNum()).orElse(null);

        Event event = new Event(member, eventAddDTO);
        Long eventNum = eventRepository.save(event).getEventNum();

        List<EventImage> eventImages = addImage(eventNum, eventImageList);

        for(EventImage eventImage : eventImages) {
            eventImageRepository.save(eventImage);
        }

    }

    // FAQ 게시판 작성
    @Override
    @Transactional
    public void addFAQ(FAQAddDTO faqAddDTO) {

        Member member = memberRepository.findById(faqAddDTO.getMemberNum()).orElse(null);
        BoardCategory boardCategory = boardCategoryRepository.findById(faqAddDTO.getBoardCategoryNum()).orElse(null);

        Board board = new Board(member, boardCategory, faqAddDTO);
        boardRepository.save(board);

    }

    @Override
    public List<EventImage> addImage(Long eventNum, List<MultipartFile> multipartFiles) throws Exception {

        List<EventImage> eventImageList = new ArrayList<>();
        Event event = eventRepository.findById(eventNum).orElse(null);

        for(MultipartFile multipartFile : multipartFiles) {

            if(!multipartFile.isEmpty()) {

                String originFileName = multipartFile.getOriginalFilename();
                String saveFileName = addImagePath(multipartFile);

                EventImage eventImage = new EventImage(event, originFileName, saveFileName);
                eventImageList.add(eventImage);
            }
        }

        return eventImageList;
    }

    @Override
    public String addImagePath(MultipartFile multipartFile) throws Exception{

        if(multipartFile.isEmpty()) {
            return null;
        }

        String imagePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images\\hwt\\event";

        String originFileName = multipartFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf(".") + 1);
        String uuid = UUID.randomUUID().toString();
        String saveFileName = uuid + "." + ext;

        multipartFile.transferTo(new File(imagePath, saveFileName));

        return saveFileName;
    }

}

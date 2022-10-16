package com.phoenix.howabouttoday.board.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class EventImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventImageNum; // 게시글 이미지 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_num")
    private Event event; // 이벤트 게시글 번호

    @Column(nullable = false)
    private String eventOriginFileName; // 게시글 이미지 기존 파일 이름

    @Column(nullable = false)
    private String eventSaveFileName; // 게시글 이미지 저장 파일 이름

    @Builder
    public EventImage(Event event, String eventOriginFileName, String eventSaveFileName) {
        this.event = event;
        this.eventOriginFileName = eventOriginFileName;
        this.eventSaveFileName = eventSaveFileName;
    }

}

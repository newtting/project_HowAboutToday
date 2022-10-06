--  리뷰
CREATE TABLE T_REVIEW (
  memberNum int,
  accomNum int,
  roomNum int,
  orderNum int,
  reviewNum int auto_increment,
  reviewRating DECIMAL(2,1) NOT NULL,      -- 평점
  reviewCreated datetime NOT NULL,
  reviewContent varchar(1000) NOT NULL,    -- 내용.
  PRIMARY KEY (`reviewNum`),
  CONSTRAINT FK_4 FOREIGN KEY (orderNum) REFERENCES T_RESERVATION(orderNum)on delete cascade,
  CONSTRAINT FK_6 FOREIGN KEY (memberNum) REFERENCES T_MEMBER(memberNum)on delete cascade,
  CONSTRAINT FK_7 FOREIGN KEY (accomNum) REFERENCES T_ACCOMMODATION(accomNum)on delete cascade,
  CONSTRAINT FK_8 FOREIGN KEY (roomNum) REFERENCES T_ROOM(roomNum)on delete cascade
)AUTO_INCREMENT=1;


INSERT INTO `T_REVIEW` (`memberNum`, `accomNum`,`roomNum`,`orderNum`,`reviewRating`,`reviewCreated`,`reviewContent` )
VALUES
(1,	3,	1,	1, 2.5, "2022-10-26", "Automatic context help is disabled. Use the toolbar to manually get help for the current caret position or to toggle automatic help."),
(1,	11,	2,	2, 3.0, "2022-10-28", "[JavaScript] 현재 위치를 지도에 찍어주는 Geolocationhttps"),
(3,	4,	3,	3, 4.0, "2022-11-25", "구글 맵을 API로 가져오려면 billing 결제 정보를 업데이트하고 confirm을 받아야 온전한 지도, marker 까지 표시할 수 있다. 아직 나의 결제 정보는 confirm 중이여"),
(4,	5,	1,	4, 3.5, "2022-12-14", "현재 창의 최 상단으로부터 내가 스크롤 이벤트 주려는 div의 최상단 = 1500"),
(5,	16,	2,	5, 2.5, "2022-10-16", "그리고 javascript를 사용할 때 좀더 편리하게 사용하기 위해서 다음과 같은 코드를 사용하고는 합니다. const map = {};  insert key-value-pair map[' ."),
(6,	7,	1,	6, 2.5, "2022-11-30", "포항시는 대한민국 경상북도 동해안에 있는 시이다. 시의 중심으로 흐르는 형산강이 영일만에 유입되면서 넓은 충적평야를 형성하고 있다."),
(8,	8,	2,	7, 4.0, "2022-10-29", "김천시는 대한민국 경상북도 서부에 있는 시이다. 동쪽은 금오산, 서쪽은 황악산으로 소백산맥의 일맥이 산악 지대이다. "),
(8,	9,	1,	8, 1.0, "2022-11-27", "경부고속도로와 경부선이 지나며, 대전과 대구의 중간 지점에 있다. 율곡동 일원에는 한국도로공사 등이 이전하여 혁신도시가 조성되고 있다."),
(9,	15,	1,	9, 3.5, "2022-10-29", "1968년부터 포항제철이 조성되면서 철강 산업을 기반으로 경상북도 에서 많이 발전했고, 주민등록 인구는 약 50만명이다.위키백과"),
(10, 13, 3,	10, 3.0, "2022-12-31", "군산시는 대한민국 전라북도 북서부 해안가에 있는 시이다.");
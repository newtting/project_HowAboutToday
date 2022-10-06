-- create user '아이디'@'%' identified by '비밀번호';	-- 아이디/비밀번호 생성

-- grant select, insert, update on DB명.* to '아이디'@'%';	-- 특정 DB에 대한 특정권한(update나 insert등) 주기
-- grant all privileges on *.* to '아이디'@'localhost';		-- 모든 DB에 모든 권한주기
-- grant all privileges on DB명.* to '아이디'@'localhost';	-- 특정 DB에 대한 모든 권한주기

-- FLUSH PRIVILEGES; -- 최종적으로 권한을 적용시킴

-- DROP USER [user명]@[server명]; -- 유저 삭제
-- ex) drop user gillog@localhost;


create user 'phoenix'@'%' identified by 'a123';
CREATE DATABASE how_about_today_db default CHARACTER SET UTF8;
grant all privileges on how_about_today_db.* to 'phoenix'@'%';	-- 특정 DB에 대한 모든 권한주기
FLUSH PRIVILEGES; -- 모든 권한 적용
-- DROP USER  phoenix@'%'; -- 유저 삭제

--  멤버
CREATE TABLE T_MEMBER (
  memberNum int auto_increment,
  email varchar(40) NOT NULL,
  pw varchar(20) NOT NULL,
  nickName varchar(50) NOT NULL,
  memberTel varchar(20) NOT NULL,
--  memberPoint int NOT NULL, -- 포인트 일단 빼고
  memberGrade int NOT NULL, --  회원 등급: 일반회원, 판매자, 관리자
  PRIMARY KEY (`id`)
)AUTO_INCREMENT=1;

--  쿠폰
CREATE TABLE T_COUPON (
  couponNum int auto_increment,
  couponName varchar(50) NOT NULL,
  discountPrice int NOT NULL, --  고정 할인 금액
  couponStartDate datetime NOT NULL,
  couponEndDate datetime NOT NULL,
  useTerms int NOT NULL,  --  사용 조건(ex. 40,000원 이상)
  PRIMARY KEY (`couponNum`)
)AUTO_INCREMENT=1;

--  멤버와 쿠폰간의 N:M 관계를 위한 테이블
CREATE TABLE T_MEMBER_VIEW_COUPON (
  memberNum int,
  couponNum int,
  CONSTRAINT FK_23 FOREIGN KEY (memberNum) REFERENCES T_MEMBER(memberNum)on delete cascade,
  CONSTRAINT FK_24 FOREIGN KEY (couponNum) REFERENCES T_COUPON(couponNum)on delete cascade
);

--  지역
CREATE TABLE T_REGION (
  regionNum int auto_increment,
  regionName varchar(20) NOT NULL,
  regionParentNum int NOT NULL,
  PRIMARY KEY (`regionNum`)
)AUTO_INCREMENT=1;

--  숙소 카테고리
CREATE TABLE T_ACCOM_CATEGORY (
  accomCategoryNum int auto_increment,
  accomCategoryName varchar(50) NOT NULL,
  PRIMARY KEY (`accomCategoryNum`)
)AUTO_INCREMENT=1;

--  숙소
CREATE TABLE T_ACCOMMODATION (
  accomNum int auto_increment,
  accomName varchar(50) NOT NULL,
  accomTel varchar(50) NOT NULL,
  accomCategoryNum int NOT NULL,   -- 카테고리 (모텔, 호텔, 펜션)
  regionNum int NOT NULL,       -- 지역
  accomAddress varchar(200) NOT NULL,
  accomRating DECIMAL(2,1) NOT NULL,
  accomWishListCount int NOT null,
  totalreviewNum int NOT NULL,   -- 숙소의 총 리뷰 수
  latitude decimal(16,14) NOT NULL,	-- 위도
  longitude decimal(17,14) NOT NULL,	-- 경도
  lowPrice int NOT NULL,         -- 숙소의 모든 객실중에서 가장 낮은 가격
  reserveRange int NOT NULL,      -- 예약 가능 범위(예를 들어서 60으로 설정해두면 오늘로부터 +60일까지만 예약이 가능합니다.)
  PRIMARY KEY (`accomNum`),
  CONSTRAINT FK_9 FOREIGN KEY (regionNum) REFERENCES T_REGION(regionNum)on delete cascade,
  CONSTRAINT FK_25 FOREIGN KEY (accomCategoryNum) REFERENCES T_ACCOM_CATEGORY (accomCategoryNum)on delete cascade
)AUTO_INCREMENT=1;

--  숙소 이미지
CREATE TABLE T_ACCOM_IMAGE (
  accomNum int,
  accomOriginFileName varchar(100) NOT NULL,
  accomSaveFileName varchar(100) NOT NULL,
  CONSTRAINT FK_3 FOREIGN KEY (accomNum) REFERENCES T_ACCOMMODATION(accomNum)on delete cascade
);

--  객실
CREATE TABLE T_ROOM (
  accomNum int,
  roomNum int auto_increment,
  roomName varchar(50) NOT NULL,
  defaultGuest int NOT NULL,
  maxGuest int NOT NULL,
  price int NOT NULL,
  restStartTime varchar(20) NOT NULL,
  restEndTime varchar(20) NOT NULL,
  roomInfo varchar(1000) NOT NULL,
  PRIMARY KEY (`roomNum`),
  CONSTRAINT FK_26 FOREIGN KEY (accomNum) REFERENCES T_ACCOMMODATION(accomNum)on delete cascade
)AUTO_INCREMENT=1;
-- 원래는 객실 가격을 테이블로 나눴는데 굳이 필요가 없다는 판단이 들어서 객실테이블로 합쳤습니다.

--  객실 정보
CREATE TABLE T_ROOM_RESERVATION_INFO (
  accomNum int,
  roomNum int,
  useStart date NOT NULL,
  useEnd date NOT NULL,
  CONSTRAINT FK_1 FOREIGN KEY (accomNum) REFERENCES T_ACCOMMODATION (accomNum)on delete cascade,
  CONSTRAINT FK_2 FOREIGN KEY (roomNum) REFERENCES T_ROOM (roomNum)on delete cascade
);
-- 이 테이블은 날짜를 선택했을 때 해당 숙소의 객실이 예약이 가능한지를 판단합니다.
-- 예를 들어 유저A가 숙소A의 객실X를 10월 1일을 예약했다면 이 INFO에 숙소번호와 객실번호와 날짜가 저장됩니다.
-- 그리고 유저 B가 숙소A의 페이지에서 10월 1일을 선택하면 INFO의 정보를 읽어와서 10월 1일 객실 X는 예약 마감으로 보입니다.


--  객실-이미지
CREATE TABLE T_ROOM_IMAGE (
  accomNum int,
  roomNum int,
  roomOriginFileName varchar(100) NOT NULL,
  roomSaveFileName varchar(100) NOT NULL,
  CONSTRAINT FK_18 FOREIGN KEY (roomNum) REFERENCES T_ROOM(roomNum)on delete cascade,
  CONSTRAINT FK_19 FOREIGN KEY (accomNum) REFERENCES T_ACCOMMODATION(accomNum)on delete cascade
);

--  장바구니 숙소
-- DROP TABLE T_CART_ACCO;
-- CREATE TABLE T_CART_ACCO (
--   memberNum int,
--   accommodationNum int,
--   CONSTRAINT FK_10 FOREIGN KEY T_CART_ACCO(memberNum) REFERENCES T_MEMBER(memberNum),
--   CONSTRAINT FK_11 FOREIGN KEY T_CART_ACCO(accommodationNum) REFERENCES T_ACCOMMODATION(accommodationNum)
-- );

--  장바구니
CREATE TABLE T_CART (
  memberNum int,
  accomNum int,
  roomNum int,
  useStart date NOT NULL,
  useEnd date NOT NULL,
  price int NOT NULL,
  CONSTRAINT FK_11 FOREIGN KEY (memberNum) REFERENCES T_MEMBER(memberNum)on delete cascade,
  CONSTRAINT FK_12 FOREIGN KEY (accomNum) REFERENCES T_ACCOMMODATION(accomNum)on delete cascade,
  CONSTRAINT FK_13 FOREIGN KEY (roomNum) REFERENCES T_ROOM(roomNum)on delete cascade
);

--  편의 시설
CREATE TABLE T_FACILITIES (
  facilityNum int auto_increment,
  facilityName varchar(50) NOT NULL,
  PRIMARY KEY (`facilityNum`)
)AUTO_INCREMENT=1;

--  찜하기
CREATE TABLE T_WISHLIST (
  memberNum int,
  accomNum int,
  CONSTRAINT FK_14 FOREIGN KEY (memberNum) REFERENCES T_MEMBER(memberNum)on delete cascade,
  CONSTRAINT FK_15 FOREIGN KEY (accomNum) REFERENCES T_ACCOMMODATION(accomNum)on delete cascade
);

--  주문
-- DROP TABLE T_ORDER;
-- CREATE TABLE T_ORDER (
--   memberNum int,
--   orderNum int PRIMARY KEY,
--   orderDate datetime NOT NULL,
--   CONSTRAINT FK_16 FOREIGN KEY T_ORDER(memberNum) REFERENCES T_MEMBER(memberNum)
-- );

-- 예약 상태
CREATE TABLE T_RESERVATION_STATE (
  reserveStatus int auto_increment,
  orderStatus varchar(20),
  PRIMARY KEY (`reserveStatus`)
)AUTO_INCREMENT=1;
-- 상태는 아마 3개정도? 뿐이겠지만 이렇게 나눠 놓는 게 추후에 상태가 추가 되면 더 구현에 좋을 것 같아서 테이블로 만들었습니다.

--  예약
CREATE TABLE T_RESERVATION (
  memberNum int,
  accomNum int,
  roomNum int,
  reserveStatus int,
  orderNum int auto_increment,
  orderDate datetime NOT NULL,
  useStartDate datetime NOT NULL,
  useEndDate datetime NOT NULL,
  price int NOT NULL,
  PRIMARY KEY (`orderNum`),
  CONSTRAINT FK_16 FOREIGN KEY (memberNum) REFERENCES T_MEMBER(memberNum)on delete cascade,
  CONSTRAINT FK_17 FOREIGN KEY (accomNum) REFERENCES T_ACCOMMODATION(accomNum)on delete cascade,
  CONSTRAINT FK_46 FOREIGN KEY (roomNum) REFERENCES T_ROOM(roomNum)on delete cascade,
  CONSTRAINT FK_5 FOREIGN KEY (reserveStatus) REFERENCES T_RESERVATION_STATE(reserveStatus)on delete cascade
)AUTO_INCREMENT=1;

--  숙소와 편의시설간의 N:M 관계를 위한 테이블
CREATE TABLE T_ACCOM_VIEW_FACILITIES (
  accomNum int,
  facilities int,
  CONSTRAINT FK_21 FOREIGN KEY (accomNum) REFERENCES T_ACCOMMODATION(accomNum)on delete cascade,
  CONSTRAINT FK_22 FOREIGN KEY (facilities) REFERENCES T_FACILITIES(facilityNum)on delete cascade
);

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

--  리뷰이미지
CREATE TABLE T_REVIEW_IMAGE (
  reviewNum int,
  reviewOriginFileName varchar(100) NOT NULL,
  reviewSaveFileName varchar(100) NOT NULL,
  CONSTRAINT FK_20 FOREIGN KEY (reviewNum) REFERENCES T_REVIEW(reviewNum) on delete cascade
);

--  리뷰 답글
CREATE TABLE T_REPLY (
  memberNum int,    -- 판매자
  accomNum int,
  roomNum int,
  orderNum int,
  reviewNum int,
  replyNum int auto_increment,
  replyCreate datetime NOT NULL,
  replyContent varchar(1000) NOT NULL,
  PRIMARY KEY (`replyNum`),
  CONSTRAINT FK_36 FOREIGN KEY (memberNum) REFERENCES T_MEMBER(memberNum)on delete cascade,
  CONSTRAINT FK_37 FOREIGN KEY (accomNum) REFERENCES T_ACCOMMODATION(accomNum)on delete cascade,
  CONSTRAINT FK_38 FOREIGN KEY (roomNum) REFERENCES T_ROOM(roomNum)on delete cascade,
  CONSTRAINT FK_44 FOREIGN KEY (orderNum) REFERENCES T_RESERVATION(orderNum)on delete cascade,
  CONSTRAINT FK_34 FOREIGN KEY (reviewNum) REFERENCES T_REVIEW(reviewNum)on delete cascade
)AUTO_INCREMENT=1;

-- 게시판 카테고리
CREATE TABLE T_BOARD_CATEGORY(
	boardCategoryNum int auto_increment,
	boardCategoryName varchar(20) NOT NULL,
	boardParentNum int NOT NULL,
	PRIMARY KEY (`boardCategoryNum`)
)AUTO_INCREMENT=1;


-- 게시판
CREATE TABLE T_BOARD (
	boardNum int auto_increment,
	boardCategoryNum int NOT NULL,
	boardTitle varchar(200) NOT NULL,
	boardContent varchar(3096),
	boardCreate datetime NOT NULL,
	PRIMARY KEY (`boardNum`),
CONSTRAINT FK_27 FOREIGN KEY (boardCategoryNum) REFERENCES T_BOARD_CATEGORY(boardCategoryNum) on delete cascade
)AUTO_INCREMENT=1;

--  게시판 이미지
CREATE TABLE T_BOARD_IMAGE (
    boardNum int,
    boardOriginFileName varchar(100) NOT NULL,
    boardSaveFileName varchar(100) NOT NULL,
    CONSTRAINT FK_3 FOREIGN KEY (boardNum) REFERENCES T_BOARD(boardNum) on delete cascade
);

DROP TABLE T_MEMBER;
DROP TABLE T_COUPON;
DROP TABLE T_MEMBER_VIEW_COUPON;
DROP TABLE T_REGION;
DROP TABLE T_ACCOM_CATEGORY;
DROP TABLE T_ACCOMMODATION;
DROP TABLE T_ACCOM_IMAGE;
DROP TABLE T_ROOM;
DROP TABLE T_ROOM_RESERVATION_INFO;
DROP TABLE T_ROOM_IMAGE;

DROP TABLE T_CART;
DROP TABLE T_FACILITIES;
DROP TABLE T_WISHLIST;
DROP TABLE T_RESERVATION_STATE;
DROP TABLE T_RESERVATION;
DROP TABLE T_ACCOM_VIEW_FACILITIES;
DROP TABLE T_REVIEW;
DROP TABLE T_REPLY;
DROP TABLE T_REVIEW_IMAGE;
DROP TABLE T_BOARD;
DROP TABLE T_BOARD_CATEGORY;
DROP TABLE T_BOARD_IMAGE;


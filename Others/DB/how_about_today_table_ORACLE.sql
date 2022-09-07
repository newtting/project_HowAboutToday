-- 멤버
DROP TABLE T_MEMBER CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_MEMBER (
  memberNum number(10) PRIMARY KEY,
  email VARCHAR2(40) NOT NULL,
  pw VARCHAR2(20) NOT NULL,
  nickName VARCHAR2(50) NOT NULL,
  tel VARCHAR2(20) NOT NULL,
  memberPoint NUMBER(10) NOT NULL,
  grade NUMBER(10) NOT NULL -- 회원의 종류 일반, 판매자, 관리자
);

-- 쿠폰
DROP TABLE T_COUPON CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_COUPON (
  couponNum NUMBER(10) PRIMARY KEY,
  couponName VARCHAR2(50) NOT NULL,
  discountPrice NUMBER(10) NOT NULL, -- 고정 할인 금액
  startDate DATE NOT NULL,
  endDate DATE NOT NULL,
  useRules NUMBER(10) NOT NULL  -- 사용 조건(ex. 40,000원 이상)
);

-- 멤버와 쿠폰간의 N:M 관계를 위한 테이블
DROP TABLE T_MEMBER_VIEW_COUPON CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_MEMBER_VIEW_COUPON (
  memberNum number(10),
  couponNum number(10),
  CONSTRAINTS FK_23 FOREIGN KEY (memberNum) REFERENCES T_MEMBER(memberNum),
  CONSTRAINTS FK_24 FOREIGN KEY (couponNum) REFERENCES T_COUPON(couponNum)
);

-- 지역
DROP TABLE T_REGION CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_REGION (
  regionNum number(10) PRIMARY KEY,
  regionName VARCHAR2(20) NOT NULL,
  parentNum NUMBER(10) NOT NULL
);

-- 숙소 카테고리
DROP TABLE T_ACCO_CATEGORY CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_ACCO_CATEGORY (
  categoryNum number(10) PRIMARY KEY,
  categoryName VARCHAR2(50) NOT NULL
);

-- 숙소
DROP TABLE T_ACCOMMODATION CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_ACCOMMODATION (
  accommodationNum number(10) PRIMARY KEY,
  accommodationName VARCHAR2(50) NOT NULL,
  tel VARCHAR2(50) NOT NULL,
  categoryNum number(10) NOT NULL,   --카테고리 (모텔, 호텔, 펜션)
  regionNum NUMBER(10) NOT NULL,       --지역
  accommodationAddress VARCHAR2(200) NOT NULL,
  rating NUMBER(2,1) NOT NULL,
  ratingCount NUMBER(10) NOT NULL,
  latitude decimal(16,14) NOT NULL,	--위도
  longitude decimal(17,14) NOT NULL,	--경도
  lowPrice number(10) NOT NULL,         --숙소의 모든 객실중에서 가장 낮은 가격
  reservationRange number(10) NOT NULL,      --예약 가능 범위(예를 들어서 60으로 설정해두면 오늘로부터 +60일까지만 예약이 가능합니다.)
  CONSTRAINT FK_9 FOREIGN KEY (regionNum) REFERENCES T_REGION(regionNum),
  CONSTRAINT FK_25 FOREIGN KEY (categoryNum) REFERENCES T_ACCO_CATEGORY (categoryNum)
);

-- 숙소 이미지
DROP TABLE T_ACCO_IMAGE CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_ACCO_IMAGE (
  accommodationNum number(10),
  originFileName VARCHAR2(100) NOT NULL,
  saveFileName VARCHAR2(100) NOT NULL,
  CONSTRAINT FK_3 FOREIGN KEY (accommodationNum) REFERENCES T_ACCOMMODATION(accommodationNum)
);

-- 객실
DROP TABLE T_ROOM CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_ROOM (
  accommodationNum number(10),
  roomNum number(10) PRIMARY KEY,
  roomName VARCHAR2(50) NOT NULL,
  defaultGuest number(10) NOT NULL,
  maxGuest number(10) NOT NULL,
  stayStartDate DATE NOT NULL,      -- 숙박 시작일
  stayEndDate DATE NOT NULL,       -- 숙박 종료일
  weekdayPrice number(10) NOT NULL,
  weekdayDiscount number(10) NOT NULL,
  weekendPrice number(10) NOT NULL,
  weekendDiscount number(10) NOT NULL,
  restStartTime DATE NOT NULL,
  restEndTime DATE NOT NULL,
  info VARCHAR2(1000) NOT NULL,
  CONSTRAINT FK_26 FOREIGN KEY (accommodationNum) REFERENCES T_ACCOMMODATION(accommodationNum)
);
--원래는 객실 가격을 테이블로 나눴는데 굳이 필요가 없다는 판단이 들어서 객실테이블로 합쳤습니다.

-- 객실 정보
DROP TABLE T_ROOM_RESERVATION_INFO CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_ROOM_RESERVATION_INFO (
  accommodationNum number(10),
  roomNum number(10),
  reservationDate DATE NOT NULL,
  CONSTRAINT FK_1 FOREIGN KEY (accommodationNum) REFERENCES T_ACCOMMODATION (accommodationNum),
  CONSTRAINT FK_2 FOREIGN KEY (roomNum) REFERENCES T_ROOM (roomNum)
);
--이 테이블은 날짜를 선택했을 때 해당 숙소의 객실이 예약이 가능한지를 판단합니다.
--예를 들어 유저A가 숙소A의 객실X를 10월 1일을 예약했다면 이 INFO에 숙소번호와 객실번호와 날짜가 저장됩니다.
--그리고 유저 B가 숙소A의 페이지에서 10월 1일을 선택하면 INFO의 정보를 읽어와서 10월 1일 객실 X는 예약 마감으로 보입니다.


-- 객실-이미지
DROP TABLE T_ROOM_IMAGE CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_ROOM_IMAGE (
  accommodationNum number(10),
  roomNum number(10),
  originFileName VARCHAR2(100) NOT NULL,
  saveFileName VARCHAR2(100) NOT NULL,
  CONSTRAINT FK_18 FOREIGN KEY (roomNum) REFERENCES T_ROOM(roomNum),
  CONSTRAINT FK_19 FOREIGN KEY (accommodationNum) REFERENCES T_ACCOMMODATION(accommodationNum)
);

-- 장바구니 숙소
--DROP TABLE T_CART_ACCO CASCADE CONSTRAINTS PURGE;
--CREATE TABLE T_CART_ACCO (
--  memberNum number(10),
--  accommodationNum number(10),
--  CONSTRAINT FK_10 FOREIGN KEY T_CART_ACCO(memberNum) REFERENCES T_MEMBER(memberNum),
--  CONSTRAINT FK_11 FOREIGN KEY T_CART_ACCO(accommodationNum) REFERENCES T_ACCOMMODATION(accommodationNum)
--);

-- 장바구니
DROP TABLE T_CART CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_CART (
  memberNum number(10),
  accommodationNum number(10),
  roomNum number(10),
  startDate DATE NOT NULL,
  endDate DATE NOT NULL,
  price number(10) NOT NULL,
  CONSTRAINT FK_11 FOREIGN KEY (memberNum) REFERENCES T_MEMBER(memberNum),
  CONSTRAINT FK_12 FOREIGN KEY (accommodationNum) REFERENCES T_ACCOMMODATION(accommodationNum),
  CONSTRAINT FK_13 FOREIGN KEY (roomNum) REFERENCES T_ROOM(roomNum)
);

-- 편의 시설
DROP TABLE T_FACILITIES CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_FACILITIES (
  facilityNum number(10) PRIMARY KEY,
  facilityName VARCHAR2(50) NOT NULL
);

-- 찜하기
DROP TABLE T_WISHLIST CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_WISHLIST (
  memberNum number(10),
  accommodationNum number(10),
  CONSTRAINT FK_14 FOREIGN KEY (memberNum) REFERENCES T_MEMBER(memberNum),
  CONSTRAINT FK_15 FOREIGN KEY (accommodationNum) REFERENCES T_ACCOMMODATION(accommodationNum)
);

-- 주문
--DROP TABLE T_ORDER CASCADE CONSTRAINTS PURGE;
--CREATE TABLE T_ORDER (
--  memberNum number(10),
--  orderNum number(10) PRIMARY KEY,
--  orderDate DATE NOT NULL,
--  CONSTRAINT FK_16 FOREIGN KEY T_ORDER(memberNum) REFERENCES T_MEMBER(memberNum)
--);

--예약 상태
DROP TABLE T_RESERVATION_STATE CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_RESERVATION_STATE (
  reservationStatus number(10) PRIMARY KEY,
  statusName VARCHAR2(20)
);
--상태는 아마 3개정도? 뿐이겠지만 이렇게 나눠 놓는 게 추후에 상태가 추가 되면 더 구현에 좋을 것 같아서 테이블로 만들었습니다.

-- 예약
DROP TABLE T_RESERVATION CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_RESERVATION (
  memberNum number(10),
  accommodationNum number(10),
  reservationStatus number(10),
  orderNum number(10) NOT NULL,
  orderDate DATE NOT NULL,
  reservationNum number(10) PRIMARY KEY,
  roomName VARCHAR2(50) NOT NULL,
  useStartDate DATE NOT NULL,
  useEndDate DATE NOT NULL,
  vehicle VARCHAR2(10) NOT NULL,
  price number(10) NOT NULL,
  CONSTRAINT FK_16 FOREIGN KEY (memberNum) REFERENCES T_MEMBER(memberNum),
  CONSTRAINT FK_5 FOREIGN KEY (reservationStatus) REFERENCES T_RESERVATION_STATE(reservationStatus),
  CONSTRAINT FK_17 FOREIGN KEY (accommodationNum) REFERENCES T_ACCOMMODATION(accommodationNum)
);

-- 숙소와 편의시설간의 N:M 관계를 위한 테이블
DROP TABLE T_ACCO_VIEW_FACILITIES CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_ACCO_VIEW_FACILITIES (
  accommodationNum number(10),
  facilities number(10),
  CONSTRAINT FK_21 FOREIGN KEY (accommodationNum) REFERENCES T_ACCOMMODATION(accommodationNum),
  CONSTRAINT FK_22 FOREIGN KEY (facilities) REFERENCES T_FACILITIES(facilityNum)
);

-- 리뷰
DROP TABLE T_REVIEW CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_REVIEW (
  memberNum number(10),
  accommodationNum number(10),
  roomNum number(10),
  reservationNum number(10),
  reviewNum number(10) PRIMARY KEY,
  rating NUMBER(2,1) NOT NULL,      --평점
  reviewContent VARCHAR2(1000) NOT NULL,    --내용.
  CONSTRAINT FK_4 FOREIGN KEY (reservationNum) REFERENCES T_RESERVATION(reservationNum),
  CONSTRAINT FK_6 FOREIGN KEY (memberNum) REFERENCES T_MEMBER(memberNum),
  CONSTRAINT FK_7 FOREIGN KEY (accommodationNum) REFERENCES T_ACCOMMODATION(accommodationNum),
  CONSTRAINT FK_8 FOREIGN KEY (roomNum) REFERENCES T_ROOM(roomNum)
);

-- 리뷰이미지   
DROP TABLE T_REVIEW_IMAGE CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_REVIEW_IMAGE (
  reviewNum number(10),
  originFileName VARCHAR2(100) NOT NULL,
  saveFileName VARCHAR2(100) NOT NULL,
  CONSTRAINT FK_20 FOREIGN KEY (reviewNum) REFERENCES T_REVIEW(reviewNum)
);

--게시판
DROP TABLE T_BOARD CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_BOARD (
	boardNum NUMBER PRIMARY KEY ,
	categoryNum NUMBER NOT NULL,
	boardTitle VARCHAR2(200) NOT NULL,
	boardContent VARCHAR2(3096) NOT NULL,
	boardCreate DATE NOT NULL,
	boardModify DATE NOT NULL,
	boardHits NUMBER NOT NULL,
CONSTRAINT FK_27 FOREIGN KEY (categoryNum) REFERENCES T_BOARD_CATEGORY(categoryNum)
);

--게시판 카테고리
DROP TABLE T_BOARD_CATEGORY CASCADE CONSTRAINTS PURGE;
CREATE TABLE T_BOARD_CATEGORY(
	categoryNum NUMBER(10) PRIMARY KEY,
	categoryName VARCHAR2(20) NOT NULL,
	parentNum NUMBER(10) NOT NULL
);

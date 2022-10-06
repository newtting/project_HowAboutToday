-- 게시판 카테고리
CREATE TABLE T_BOARD_CATEGORY(
	boardCategoryNum int auto_increment,
	boardCategoryName varchar(20) NOT NULL,
	boardParentNum int NOT NULL,
	PRIMARY KEY (`boardCategoryNum`)
)AUTO_INCREMENT=1;


INSERT INTO `T_BOARD_CATEGORY` (`boardCategoryName`, `boardParentNum`)
VALUES 
("공지사항",0),
("FAQ", 0),
("정보", 0),
("이벤트", 0),
("상품/서비스", 2),
("예약/결제", 2),
("변경/취소", 2),
("쿠폰/할인", 2),
("코인/포인트", 2),
("후기/댓글", 2),
("회원/개인정보", 2),
("믿고쓰는 오늘어때", 2);
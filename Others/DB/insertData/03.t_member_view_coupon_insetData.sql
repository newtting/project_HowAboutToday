--  멤버와 쿠폰간의 N:M 관계를 위한 테이블
CREATE TABLE T_MEMBER_VIEW_COUPON (
  memberNum int,
  couponNum int,
  CONSTRAINT FK_23 FOREIGN KEY (memberNum) REFERENCES T_MEMBER(memberNum)on delete cascade,
  CONSTRAINT FK_24 FOREIGN KEY (couponNum) REFERENCES T_COUPON(couponNum)on delete cascade
);


INSERT INTO `T_MEMBER_VIEW_COUPON` (`memberNum`, `couponNum`)
VALUES
(1,	3),
(1,	4),
(1,	5),
(2,	1),
(2,	2),
(3,	1),
(3,	5),
(4,	6),
(4,	7),
(5,	8),
(6,	9),
(7, 10),
(7,	7),
(8,	1),
(8,	7),
(9,	9),
(10,	1),
(10,	8);
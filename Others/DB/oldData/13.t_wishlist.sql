--  찜하기
CREATE TABLE T_WISHLIST (
  memberNum int,
  accomNum int,
  CONSTRAINT FK_14 FOREIGN KEY (memberNum) REFERENCES T_MEMBER(memberNum)on delete cascade,
  CONSTRAINT FK_15 FOREIGN KEY (accomNum) REFERENCES T_ACCOMMODATION(accomNum)on delete cascade
);

INSERT INTO `T_WISHLIST` (`memberNum`, `accomNum`)
VALUES
(1, 12),
(1, 1),
(2, 11),
(2, 4),
(2, 5),
(3, 6),
(3, 17),
(4, 8),
(4, 9),
(5, 1),
(5, 2),
(6, 13),
(7, 3),
(8, 4),
(9, 5),
(9, 6);
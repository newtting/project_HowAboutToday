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

INSERT INTO `T_CART` (`memberNum`,`accomNum`, `roomNum`, `useStart`, `useEnd`,`price`)
VALUES
(1, 1,1, "2022-11-20", "2022-11-24", 30000),
(1, 2,3,"2022-12-26", "2022-12-26", 89800),
(2, 3,2, "2022-10-20", "2022-10-26", 75000),
(3, 4,1, "2022-11-12", "2022-11-13", 80000),
(4, 16,5, "2022-11-10", "2022-11-14", 60000),
(5, 11,1, "2022-12-20", "2022-12-24", 89000),
(6, 19,4, "2022-12-23", "2022-12-24", 35000),
(7, 5,1, "2022-11-20", "2022-11-24", 50000),
(8, 9,2, "2022-10-20", "2022-10-24", 90000);
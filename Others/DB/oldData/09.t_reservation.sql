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

INSERT INTO `T_RESERVATION` (`memberNum`,`accomNum`, `roomNum`, `reserveStatus`,`orderDate`,`useStartDate`,`useEndDate`,`price`)
VALUES
(1, 3, 1, 1, "2022-10-06", "2022-10-20", "2022-10-25", 55000),
(1, 11, 2, 1, "2022-10-16", "2022-10-26", "2022-10-27", 99000),
(3, 4, 3, 1, "2022-11-06", "2022-11-20", "2022-11-25", 45000),
(4, 5, 1, 1, "2022-12-06", "2022-12-12", "2022-12-14", 50000),
(5, 16, 2, 1, "2022-10-06", "2022-10-10", "2022-10-15", 60000),
(6, 7, 1, 1, "2022-11-18", "2022-11-20", "2022-11-25", 46000),
(8, 8, 2, 1, "2022-10-26", "2022-10-27", "2022-10-28", 65000),
(8, 9, 1, 1, "2022-11-06", "2022-11-23", "2022-11-25", 120000),
(9, 15, 1, 1, "2022-10-01", "2022-10-20", "2022-10-25", 59400),
(10, 13, 3, 1, "2022-12-01", "2022-12-20", "2022-12-25", 100000),

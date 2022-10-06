CREATE TABLE T_ROOM_RESERVATION_INFO (
  accomNum int,
  roomNum int,
  useStart date NOT NULL,
  useEnd date NOT NULL,
  CONSTRAINT FK_1 FOREIGN KEY (accomNum) REFERENCES T_ACCOMMODATION (accomNum)on delete cascade,
  CONSTRAINT FK_2 FOREIGN KEY (roomNum) REFERENCES T_ROOM (roomNum)on delete cascade
);

INSERT INTO `T_ROOM_RESERVATION_INFO` (`accomNum`,`roomNum`, `useStart`, `useEnd`)
VALUES
(3, 1, "2022-10-20", "2022-10-24"),
(11, 2,"2022-10-26", "2022-10-26"),
(4, 3, "2022-11-20", "2022-11-26"),
(5, 1, "2022-12-12", "2022-12-13"),
(16, 2, "2022-10-10", "2022-10-14"),
(7, 1, "2022-11-20", "2022-11-24"),
(8, 2, "2022-11-23", "2022-11-24"),
(15, 1, "2022-10-20", "2022-10-24"),
(13, 3, "2022-12-20", "2022-12-24");
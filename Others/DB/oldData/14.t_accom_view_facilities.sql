--  숙소와 편의시설간의 N:M 관계를 위한 테이블
CREATE TABLE T_ACCOM_VIEW_FACILITIES (
  accomNum int,
  facilities int,
  CONSTRAINT FK_21 FOREIGN KEY (accomNum) REFERENCES T_ACCOMMODATION(accomNum)on delete cascade,
  CONSTRAINT FK_22 FOREIGN KEY (facilities) REFERENCES T_FACILITIES(facilityNum)on delete cascade
);

INSERT INTO `T_ACCOM_VIEW_FACILITIES` (`accomNum`, `facilities`)
VALUES
(1, 12),
(1, 1),
(2, 11),
(2, 24),
(2, 35),
(3, 46),
(3, 17),
(4, 8),
(4, 9),
(5, 11),
(5, 2),
(6, 13),
(7, 23),
(8, 4),
(9, 5),
(9, 6);
(9, 36);
(10, 6);
(10, 7);
(11, 12),
(11, 1),
(12, 11),
(12, 44),
(12, 50),
(13, 6),
(13, 17),
(14, 18),
(14, 19),
(15, 3),
(15, 34),
(16, 15),
(17, 48),
(18, 4),
(19, 15),
(19, 6);
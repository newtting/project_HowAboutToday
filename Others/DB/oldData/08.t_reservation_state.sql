-- 예약 상태
CREATE TABLE T_RESERVATION_STATE (
  reserveStatus int auto_increment,
  orderStatus varchar(20),
  PRIMARY KEY (`reserveStatus`)
)AUTO_INCREMENT=1;

INSERT INTO `T_RESERVATION_STATE` (`orderStatus`)
VALUES
("이용 전"),
("이용 중"),
("이용 완료"),
("취소");

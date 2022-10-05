CREATE TABLE T_REGION (
  regionNum int auto_increment,
  regionName varchar(20) NOT NULL,
  regionParentNum int NOT NULL,
  PRIMARY KEY (`regionNum`)
)AUTO_INCREMENT=1;


INSERT INTO `T_REGION` (`regionName`,`regionParentNum`)
VALUES
  ("서울",0),
  ("경기",0),
  ("인천",0),
  ("강원",0),
  ("제주",0),
  ("대전",0),
  ("충북",0),
  ("충남/세종",0),
  ("부산",0),
  ("울산",0),
  ("경남",0),
  ("대구",0),
  ("경북",0),
  ("광주",0),
  ("전남",0),
  ("전주/전북",0);




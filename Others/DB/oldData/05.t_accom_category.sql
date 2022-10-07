CREATE TABLE T_ACCOM_CATEGORY (
  accomCategoryNum int auto_increment,
  accomCategoryName varchar(50) NOT NULL,
  PRIMARY KEY (`accomCategoryNum`)
)AUTO_INCREMENT=1;


INSERT INTO `t_accom_category` (`accomCategoryName`)
VALUES
  ("호텔"),
  ("모텔"),
  ("펜션/풀빌라"),
  ("게하/한옥");
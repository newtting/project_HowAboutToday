--  리뷰이미지
CREATE TABLE T_REVIEW_IMAGE (
  reviewNum int,
  reviewOriginFileName varchar(100) NOT NULL,
  reviewSaveFileName varchar(100) NOT NULL,
  CONSTRAINT FK_20 FOREIGN KEY (reviewNum) REFERENCES T_REVIEW(reviewNum) on delete cascade
);

INSERT INTO `T_REVIEW_IMAGE` (`reviewNum`,`reviewOriginFileName`,`reviewSaveFileName`)
VALUES 
(1, "image103.jpg", "image103.jpg"),
(1, "image150.jpg", "image150.jpg"),
(2,  "image32.jpg", "image32.jpg"),
(3,  "image62.jpg", "image62.jpg"),
(4,  "image70.jpg", "image70.jpg"),
(5, "image90.jpg", "image90.jpg"),
(6,  "image41.jpg", "image41.jpg"),
(7,  "image97.jpg", "image97.jpg"),
(8,  "image18.jpg", "image18.jpg"),
(9,  "image41.jpg", "image41.jpg"),
(10, "image76.jpg", "image76.jpg");
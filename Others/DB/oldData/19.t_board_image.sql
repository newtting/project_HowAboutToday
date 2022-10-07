
--  게시판 이미지
CREATE TABLE T_BOARD_IMAGE (
    boardNum int,
    boardOriginFileName varchar(100) NOT NULL,
    boardSaveFileName varchar(100) NOT NULL,
    CONSTRAINT FK_53 FOREIGN KEY (boardNum) REFERENCES T_BOARD(boardNum) on delete cascade
);


INSERT INTO `T_BOARD_IMAGE` (`boardNum`,`boardOriginFileName`,`boardSaveFileName`)
VALUES 
(1, "image17.jpg", "image17.jpg"),
(1, "image73.jpg", "image73.jpg"),
(2,  "image73.jpg", "image73.jpg"),
(3, "image10.jpg", "image10.jpg"),
(4, "image64.jpg", "image64.jpg"),
(5,  "image3.jpg", "image3.jpg"),
(6, "image120.jpg", "image120.jpg"),
(7, "image137.jpg", "image137.jpg"),
(8, "image100.jpg", "image100.jpg"),
(9,  "image69.jpg", "image69.jpg"),
(10, "image157.jpg", "image157.jpg");




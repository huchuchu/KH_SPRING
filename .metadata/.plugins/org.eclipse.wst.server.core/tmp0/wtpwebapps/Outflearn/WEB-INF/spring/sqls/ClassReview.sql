------------------------------------------ 강좌후기
DROP TABLE CLASS_REVIEW;
--글 번호 시퀀스(일반적인 번호)
DROP SEQUENCE REVIEW_NUM_SQ;

--그룹번호 시퀀스(답글이 달렸을 때 )
DROP SEQUENCE REVIEW_GROUPNO_SQ;

--글 번호 시퀀스(일반적인 번호)
CREATE SEQUENCE REVIEW_NUM_SQ;

--그룹번호 시퀀스(답글이 달렸을 때 )
CREATE SEQUENCE REVIEW_GROUPNO_SQ;


CREATE TABLE CLASS_REVIEW(
REVIEW_NUM NUMBER PRIMARY KEY,
CLASS_NUM NUMBER REFERENCES CLASS_INFO(CLASS_NUM) ON DELETE CASCADE NOT NULL,
USER_NUM NUMBER REFERENCES USER_INFO(USER_NUM) ON DELETE CASCADE NOT NULL,
REVIEW_CONTENT VARCHAR2(4000) NOT NULL,
USER_STAR NUMBER DEFAULT 1 NOT NULL ,
REVIEW_GROUPNO NUMBER NOT NULL,
REVIEW_GROUPSQ NUMBER NOT NULL,
REVIEW_TITLETAB NUMBER NOT NULL
)

INSERT INTO CLASS_REVIEW VALUES(REVIEW_NUM_SQ.NEXTVAL , 1 , 1 ,'내용' ,5 ,REVIEW_GROUPNO_SQ.NEXTVAL, 1, 0);

SELECT * FROM CLASS_REVIEW;

DELETE FROM CLASS_REVIEW WHERE USER_NUM = 1 AND REVIEW_GROUPSQ = 1
USE mysqlvs;
CREATE TABLE IF NOT EXISTS mysqlvs.member (
    mem_no      BIGINT          AUTO_INCREMENT PRIMARY KEY NOT NULL,
    mem_id      VARCHAR(20)     NOT NULL,
    mem_pw      VARCHAR(100)    NOT NULL,
    mem_nick    VARCHAR(30)     UNIQUE NOT NULL,
    ins_date    DATETIME        DEFAULT CURRENT_TIMESTAMP,
    upd_date    DATETIME        DEFAULT CURRENT_TIMESTAMP
    enabled     BIT(1)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS mysqlvs.role (
    role_no      INT         PRIMARY KEY NOT NULL,
    role_name    VARCHAR(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS mysqlvs.member_role (
    mem_no       BIGINT  NOT NULL,
    role_no      INT     NOT NULL,
    PRIMARY KEY (mem_no, role_no),
    FOREIGN KEY (mem_no)  REFERENCES member (mem_no),
    FOREIGN KEY (role_no) REFERENCES role (role_no)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS mysqlvs.board (
                                             NO         BIGINT           PRIMARY KEY AUTO_INCREMENT,
                                             TITLE      VARCHAR(100)     NOT NULL,
    CONTENTS   TEXT             NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE member_role;
DROP TABLE role;
DROP TABLE member;

SHOW TABLES;

INSERT INTO mysqlvs.role (role_no, role_name) VALUES (1, 'ADMIN');
INSERT INTO mysqlvs.role (role_no, role_name) VALUES (2, 'USER');

SELECT * FROM member;

INSERT INTO board (title, contents) values ('테스트 1', '테스트 테스트 1');
INSERT INTO board (title, contents) values ('테스트 2', '테스트 테스트 2');

commit;


SELECT
    U.MEMPW AS MEMPW,
    U.MEMID AS MEMID,
    R.ROLENAME AS ROLENAME
FROM TBL_MEMBER AS U
         INNER JOIN TBL_MEMBER_ROLE AS UR ON U.MEMNO = UR.MEMNO
         INNER JOIN TBL_ROLE AS R ON R.ROLENO = UR.ROLENO
WHERE U.MEMID = 'raccoon'

DROP TABLE TBL_MEMBER;



SELECT * FROM TBL_MEMBER;
SELECT * FROM TBL_MEMBER_ROLE;
SELECT * FROM TBL_ROLE;

delete from TBL_MEMBER WHERE 1=1;


SELECT * FROM board


SELECT * FROM TABLES


                  SHOW TABLES;
SHOW DATABASES


DROP TABLE TBL_MEMBER;

DROP TABLE TBL_ROLE;
DROP TABLE TBL_MEMBER_ROLE;


COMMIT
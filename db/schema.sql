DROP DATABASE IF EXISTS sbs_proj_2023;
CREATE DATABASE sbs_proj_2023;
USE sbs_proj_2023;

CREATE TABLE article (
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    title CHAR(100) NOT NULL,
    `body` TEXT NOT NULL
  );
  
  INSERT INTO article
  SET regDate = NOW(),
  updateDate = NOW(),
  title ='제목입니다',
  `body` = '내용입니다';
  
  
  
  INSERT INTO article
  SET regDate = NOW(),
  updateDate = NOW(),
  title ='제목1',
  `body` = '내용1';
  INSERT INTO article
  SET regDate = NOW(),
  updateDate = NOW(),
  title ='제목2',
  `body` = '내용2';

  SELECT * FROM article;

  CREATE TABLE `member` (
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    loginId CHAR(20) NOT NULL,
    `authLevel` SMALLINT(2) UNSIGNED DEFAULT 3 COMMENT '(3=일반, 7=관리자)',
    loginPw CHAR(60) NOT NULL,
    `name` CHAR(20) NOT NULL,
    `nickname` CHAR(20) NOT NULL,
    cellphoneNo CHAR(20) NOT NULL,
    email CHAR(50) NOT NULL,
    delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '(탈퇴여부)',
    delDate DATETIME COMMENT '탈퇴날짜'
  );
  
#테스트 데이터 생성
  INSERT INTO `member`
  SET regDate = NOW(),
  updateDate = NOW(),
  loginId ='admin',
  loginPw = 'admin',
  authLevel = 7,
  `name` = '관리자',
  nickname = '관리자',
  cellphoneNo ='01011111111',
  email = 'admin@gmail.com';
  
   INSERT INTO `member`
  SET regDate = NOW(),
  updateDate = NOW(),
  loginId ='mimi',
  loginPw = 'mimi',
  `name` = '회원',
  nickname = '회원',
  cellphoneNo ='01011111111',
  email = 'admin@gmail.com';
  
  INSERT INTO `member`
  SET regDate = NOW(),
  updateDate = NOW(),
  loginId ='mama',
  loginPw = 'mama',
  `name` = '회원1',
  nickname = '회원1',
  cellphoneNo ='01011111111',
  email = 'admin@gmail.com';
  
  SELECT * FROM MEMBER;

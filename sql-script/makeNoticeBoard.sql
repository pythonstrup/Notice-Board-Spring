# DB 생성
CREATE DATABASE if not exists notice_board;
use notice_board;


# 테이블 생성
drop table if exists board;
create table board(
	id int auto_increment primary key,
    title varchar(100) not null,
    content varchar(1000) not null,
    visitcount int default 0,
    postdate datetime default now() not null
);


# 더미 데이터
insert into board(title, content)
values("첫번째 게시판", "이것은 첫번째 게시판입니다."),
("두번째 게시판", "이것은 두번째 게시판입니다."),
("세번째 게시판", "이것은 세번째 게시판입니다."),
("네번째 게시판", "이것은 네번째 게시판입니다.");
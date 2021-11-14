/* 메뉴 */
DROP TABLE menu 
	CASCADE CONSTRAINTS;

/* 메뉴 */
CREATE TABLE menu (
	mid NUMBER(6) CONSTRAINT mid_pk PRIMARY KEY NOT NULL, /* 메뉴번호 */
	mname VARCHAR(50) NOT NULL, /* 메뉴명 */
	mprice INTEGER NOT NULL, /* 메뉴가격 */
    mcount INTEGER DEFAULT 1 NOT NULL, /* 메뉴수량 */
	mtype number(1) NOT NULL /* 메뉴종류 */
    
);

/* 메뉴 추가 */
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '불고기버거(콜라)', 5800, 1);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '불고기버거(사이다)', 5800, 1);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '불고기버거(환타)', 5800, 1);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '상하이버거(콜라)', 6300, 1);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '상하이버거(사이다)', 6300, 1);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '상하이버거(환타)', 6300, 1);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '불고기버거', 3500, 2);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '상하이버거', 4000, 2);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '후렌치후라이', 2000, 3);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '치즈볼', 3000,  3);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '아이스크림', 1000, 3);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '쉐이크', 1000, 3);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '콜라', 1000, 4);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '사이다', 1000, 4);
insert into menu (MID, MNAME, MPRICE, MTYPE) values (menu_seq.nextVal, '환타', 1000, 4);

--select menu_seq.currval from menu;
--시퀀스 삭제
drop sequence menu_seq;

--시퀀스생성
create sequence menu_seq
start with 1
minvalue 1
increment by 1
;
-- 메뉴수량을 1로 수정(메뉴 수량 초기화)
update menu set mcount =1;
-- 1번 메뉴를 출력
select * from menu where mid = 1;
-- 모든 행을 출력
select * from menu;
-- 저장
COMMIT;
-- commit한 부분까지 되돌리기
rollback;

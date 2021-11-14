DROP INDEX PK_users;

/* 회원 */
DROP TABLE users 
	CASCADE CONSTRAINTS;

/* 회원 */
CREATE TABLE users (
	id number(6) NOT NULL, /* 회원번호 */
	username VARCHAR2(50) NOT NULL, /* 이름 */
	userid VARCHAR2(40) NOT NULL, /* 아이디 */
	password VARCHAR2(40) NOT NULL, /* 비밀번호 */
	address VARCHAR2(255) NOT NULL, /* 주소 */
	phone VARCHAR2(30) NOT NULL, /* 전화번호 */
	email VARCHAR2(40) /* 이메일 */
);

COMMENT ON TABLE users IS '회원';

COMMENT ON COLUMN users.id IS '회원번호';

COMMENT ON COLUMN users.username IS '이름';

COMMENT ON COLUMN users.userid IS '아이디';

COMMENT ON COLUMN users.password IS '비밀번호';

COMMENT ON COLUMN users.address IS '주소';

COMMENT ON COLUMN users.phone IS '전화번호';

COMMENT ON COLUMN users.email IS '이메일';

CREATE UNIQUE INDEX PK_users
	ON users (
		id ASC
	);

ALTER TABLE users
	ADD
		CONSTRAINT PK_users
		PRIMARY KEY (
			id
		);
delete from users where id != 0;  
delete from users where id >2;   
--관리자 정보(회원번호 0 임의로 정함)
insert into users values(0, 'manager', 'm1', 'm1', '서울특별시 강남구 비트캠프', '010-0101-1010', 'jkmanager@gmail.com');  
insert into users values(users_seq.nextval, 'tName1', 'tId1', 'tPw1', '서울특별시 강남구 비트캠프', '010-0101-1010', 'jkmanager@gmail.com');  
insert into users values(users_seq.nextval, 'tName2', 'tId2', 'tPw2', '서울특별시 강남구 비트캠프', '010-0101-1010', 'jkmanager@gmail.com');  

select users_seq.currval from users;



drop sequence users_seq;
--시퀀스생성
create sequence users_seq
start with 1
minvalue 1
increment by 1
;

commit;
select * from users where userid = 123;
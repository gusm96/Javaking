DROP INDEX PK_dorder;

/* 주문정보 */
DROP TABLE dorder 
	CASCADE CONSTRAINTS;

/* 주문정보 */
CREATE TABLE dorder (
	doid NUMBER(6) NOT NULL, /* 주문번호 */
	dodate TIMESTAMP NOT NULL, /* 주문일자 */
	doprice INTEGER NOT NULL, /* 주문금액 */
	payment VARCHAR2(30) NOT NULL, /* 결제수단 */
	id NUMBER(6) Default 0 /* 회원번호 */
);


select users.uadd ,users.uphn, dorder.doprice from dorder,users where dorder.id=users.id;

select avg(sum(doprice)) from dorder GROUP BY doprice;

CREATE UNIQUE INDEX PK_dorder
	ON dorder (
		doid ASC
	);

ALTER TABLE dorder
	ADD
		CONSTRAINT PK_dorder
		PRIMARY KEY (
			doid
		);

ALTER TABLE dorder
	ADD
		CONSTRAINT FK_users_TO_dorder
		FOREIGN KEY (
			id
		)
		REFERENCES users (
			id
		);
        
        
drop SEQUENCE dorder_seq;

create SEQUENCE dorder_seq
start with 1
minvalue 1
increment by 1
;

select * from dorder;
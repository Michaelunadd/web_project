create table member(
memberNumber number primary key,
id varchar2(10) unique not null,
password varchar2(20) not null,
name varchar2(10) not null,
gender char(2) not null,
port number not null,
address1 varchar2(20) not null,
address2 varchar2(20) not null,
email varchar2(20) not null,
tel varchar2(15) not null,
grade char(2) not null,
joinDate date not null
);

alter table member add constraint ck_gender check( gender in('m','f'));
alter table member add constraint ck_email check(email like '%@%');
alter table member add constraint ck_grade check( grade in ('b','s','g','v','m'));
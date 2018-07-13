create table serviceCenter(
servicenumber number primary key,
serviceDpt varchar2(10) not null,
serviceMember number,
serviceTitle varchar2(20) not null,
servicePass varchar2(8) not null,
serviceDate date not null,
serviceText clob not null,
foreign key(serviceMember) REFERENCES member(memberNumber)
);

alter table serviceCenter add constraint ck_serviceDpt check(serviceDpt in ('notice','FAQ','private'));



create table customer(
	id varchar2(30) primary key,
	password varchar2(30)
);

insert into customer values('test','1234');

select * from customer;


select password from customer where id ='test';
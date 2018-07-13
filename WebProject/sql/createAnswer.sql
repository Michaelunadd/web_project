create table answer(
answerNumber number primary key,
answerService number not null,
answerMember number not null,
answerPass varchar2(8) not null,
answerDate date not null,
answerText clob not null,
foreign key(answerService) references serviceCenter(serviceNumber)
);
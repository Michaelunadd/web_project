create table history(
historyNumber number primary key,
historyMember number not null,
historyGoods number not null,
historyDate date not null,
foreign key(historyMember) references member(memberNumber),
foreign key(historyGoods) references goods(goodsNumber)
);
create table cart(
cartNumber number primary key,
cartMember number not null,
cartGoods number,
foreign key(cartMember) references Member(memberNumber),
foreign key(cartGoods) references goods(goodsNumber)
);
create table goods(
goodsNumber number primary key,
goodsName varchar2(20) not null,
goodsGroup1 varchar2(10) not null,
goodsGroup2 varchar2(10) not null,
goodsGroup3 varchar2(10) not null,
goodsBuyCost INTEGER not null,
goodsSellCost integer not null,
goodsDate date not null,
goodsQty INTEGER not null
);

alter table goods add constraint ck_goodsQty check(goodsQty >= 0);
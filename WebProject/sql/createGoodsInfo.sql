create table goodsInfo(
infoGoods number primary key,
infoThumb blob,
infoJPG blob,
infoTEXT clob,
FOREIGN key(infoGoods) REFERENCES goods(goodsNumber)
);

drop database auctionSystem;
create database auctionSystem;
use auctionSystem;

create table user (
	id int primary key auto_increment comment '用户id',
    userName varchar(20) unique comment '用户名',
    password varchar(32) comment '用户密码',
    idNum varchar(18) comment '身份证号',
    mobile varchar(11),
    address varchar(255),
    postalCode int
);
INSERT INTO `auctionSystem`.`user` (`userName`, `password`, `idNum`, `mobile`, `address`, `postalCode`) VALUES ('aaa', '123', '1234213412341', '1231313', '江苏省南京市鼓楼区', '123432');

create table manager(
	id int primary key auto_increment comment '管理员id',
    userName varchar(20) unique comment '管理员用户名',
    password varchar(20) comment '管理员密码'
);
INSERT INTO `auctionSystem`.`manager` (`userName`, `password`) VALUES ('root', '12345678');

create table auctionItem(
	id int primary key auto_increment comment '拍卖品id',
    name varchar(20) comment '拍卖品名',
    startPrice float comment '起拍价',
    basePrice float comment '底价',
    startTime datetime comment '开始时间',
	endTime datetime comment '结束时间',
    remark tinytext comment '描述',
    isSold int comment '是否被拍卖'
);
insert into auctionItem values (null, '青花瓷', '3000','5000','2012-5-11 11:30:11','2012-10-11 11:30:11', '青花瓷',0);
insert into auctionItem values (null, '国画', '4000','5000','2012-1-11 11:30:11','2012-11-11 11:30:11', '国画',0);

create table bidRecord(
	id int primary key auto_increment comment '出价记录表id',
	itemId int comment '出价拍卖品id',
    bidTime datetime comment '出价时间',
    bidPrice float comment '出价价格',
    userId int comment '出价用户id',
    foreign key(itemId) references auctionItem(id),
    foreign key(userId) references user(id)
);

create table soldItem(
	id int primary key auto_increment comment '成交记录表id',
    itemId int comment '拍卖品id',
    price float comment '成交价格',
    userId int comment '成交用户id',
    foreign key(itemId) references auctionItem(id),
    foreign key(userId) references user(id)
);

create table unSoldItem(
	id int primary key auto_increment comment '流拍记录表id',
    itemId int comment '拍卖品id',
    price float comment '最高出价价格',
    userId int comment '出价用户id',
    foreign key(itemId) references auctionItem(id),
    foreign key(userId) references user(id)
);




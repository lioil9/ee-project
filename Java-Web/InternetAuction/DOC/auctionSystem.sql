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

create table manager(
	id int primary key auto_increment comment '管理员id',
    userName varchar(20) unique comment '管理员用户名',
    password varchar(20) comment '管理员密码'
);

create table auctionItem(
	id int primary key auto_increment comment '拍卖品id',
    name varchar(20) comment '拍卖品名',
    startPrice float comment '起拍价',
    basePrice float comment '底价',
    startTime date comment '开始时间',
	endTime date comment '结束时间',
    remark tinytext comment '描述',
    isSold int comment '是否被拍卖'
);

create table bidRecord(
	id int primary key auto_increment comment '出价记录表id',
	itemId int comment '出价拍卖品id',
    bidTime date comment '出价时间',
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




create database my_blog;
use my_blog;

create table `user`( 
	id bigint(20) NOT NULL AUTO_INCREMENT comment '用户id',
    username varchar(64) comment '用户名，登录名',
    password varchar(64) comment '用户密码',
    avatar varchar(255) comment '用户头像地址',
    email varchar(64) comment '用户邮箱',
    status int(5) comment '用户状态，是否注销',
    createtime datetime comment '创建时间',
    last_login datetime comment '最后一次登陆时间',
    primary key(`id`)
);

create table `article`(
	id bigint(20) NOT NULL auto_increment comment '文章id',
    userid bigint(20) comment '文章所属用户id',
    title varchar(255) comment '文章标题',
    abstract varchar(255) comment '文章摘要',
    context longtext comment '文章正文',
    createtime datetime comment '文章创建时间',
    status tinyint(4) comment '文章状态,是否被删除, 0,1表示',
    primary key(`id`)
);

INSERT INTO `my_blog`.`user` (`id`, `username`, `avatar`, `email`, `password`, `status`, `createtime`, `last_login`) VALUES ('1', 'markerhub', 'https://image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/5a9f48118166308daba8b6da7e466aab.jpg', NULL, '96e79218965eb72c92a549dd5a330112', '0', '2020-04-20 10:44:01', NULL);
INSERT INTO `my_blog`.`user` (`id`, `username`, `avatar`, `email`, `password`, `status`, `createtime`, `last_login`) VALUES (null, 'test', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3002379740,3965499425&fm=26&gp=0.jpg', NULL, 'e10adc3949ba59abbe56e057f20f883e', '0', '2020-04-20 10:44:01', NULL);

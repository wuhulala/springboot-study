-- 顾客
create table customer (
   id bigint(20) not null auto_increment,
   name varchar(50) not null comment '顾客名称',
   balance bigint(20) not null default 0 comment '余额',
   primary key (`id`)
) engine=innodb default charset=utf8;

-- 产品
create table product (
  id bigint(20) not null auto_increment,
  name varchar(50) default null,
  price bigint(20) default null comment '分',
  description varchar(200) default null,
  remain int(11) default null,
  primary key (`id`)
) engine=innodb default charset=utf8;

-- 订单


CREATE TABLE order (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  customer_id bigint(20) DEFAULT NULL,
  product_id bigint(20) DEFAULT NULL,
  product_num int(11) DEFAULT NULL,
  total_cost bigint(20) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

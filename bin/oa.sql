drop database if exists oa;
create database oa;
use oa;
set names gbk;

create table employee(id int primary key auto_increment,name varchar(20),loginName varchar(20),password varchar(20),groupId int);

insert into employee (name,loginName,password,groupId)values('刘备','liubei','liubei',1);
insert into employee (name,loginName,password,groupId)values('张飞','zhangfei','zhangfei',2);
insert into employee (name,loginName,password,groupId)values('关羽','guanyu','guanyu',2);

create table loan(id int primary key auto_increment,employeeId int,title varchar(100),amount double,applyDate datetime,status int,foreign key(employeeId) references employee(id));

insert into loan(employeeId,title,amount,applyDate,status)values(2,'吃饭',1500,'2009-08-03 00:00:00.0',1);
insert into loan (employeeId,title,amount,applyDate,status)values(2,'请假',5000,'2009-08-04 00:00:00.0',2);
insert into loan (employeeId,title,amount,applyDate,status)values(3,'喝茶',10000,'2009-08-04 00:00:00.0',0);
insert into loan (employeeId,title,amount,applyDate,status)values(1,'看电影',1000,'2009-08-05 00:00:00.0',0);

select * from employee;
select * from loan;


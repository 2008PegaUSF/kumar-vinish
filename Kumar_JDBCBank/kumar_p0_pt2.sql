-- code actually used in project
--- table created for each User
create table Users(
userId integer primary key,
userFullName varchar(100),
userUsername varchar(100),
userPass varchar(100),
userFunds integer
);

--- sequence used to auto increment user id for users table
create sequence seq
increment by 1
start with 1
minvalue 1;

-- test queries
insert into Users (userfullname, userusername, userpass)
values ('Vinish', 'vinny', 'pw');

select * from Users;

drop sequence seq;
drop table accounts;
drop table users;

delete from Users where userUsername = 'ikei';

insert into Users values (nextval('betterseq'), 'Vinish', 'Kumar', 'vin', 'pw');

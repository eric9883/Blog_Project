drop user 'cos';
create user 'cos'@'%' identified by 'cos1234';

grant all privileges on *.* to 'cos'@'%';

create database blog;
use blog;

show variables like 'c%';
create database emsdb;

GRANT ALL ON emsdb.* TO maha@localhost;

create table Employee(
	emp_id int(20) primary key,
	fname varchar(30),
	lname varchar(30),
	password varchar(20),
	email varchar(40),
	emp_type varchar(10),
	date_of_joining date,
	designation varchar(40)
);


drop table if exists emp_details;
drop table if exists employee;
drop table if exists salary;

create table emp_details (
       id integer not null auto_increment,
        address varchar(100),
        date_of_birth date,
        lang_known varchar(50),
        phone_no integer,
        emp_id integer,
        primary key (id)
    ) engine=MyISAM
    
create table employee (
       emp_id integer not null auto_increment,
        date_of_joining date,
        designation integer,
        email varchar(40),
        emp_type integer,
        fname varchar(30),
        lname varchar(30),
        password varchar(20),
        primary key (emp_id)
    ) engine=MyISAM
    
create table salary (
       id integer not null auto_increment,
        basic_pay double precision,
        overall_pkg double precision,
        variable_pay double precision,
        emp_id integer,
        primary key (id)
    ) engine=MyISAM
    
alter table emp_details 
       add constraint FKq05mhq88vturlmqitg47evj33 
       foreign key (emp_id) 
       references employee (emp_id)
       
alter table salary 
       add constraint FK52i6nbheu51kqc7bfslc4wo7i 
       foreign key (emp_id) 
       references employee (emp_id)
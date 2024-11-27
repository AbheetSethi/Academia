create  database if not exists AcademicERP;

use AcademicERP;

create table if not exists departments(
    department_id bigint auto_increment primary key,
    name varchar(100) not null unique,
    capacity int not null
);

create table if not exists employees(
    employee_id bigint auto_increment primary key,
    first_name varchar(25) not null,
    last_name varchar(25),
    email varchar(100) unique not null,
    title varchar(25),
    dep_id bigint not null,
    password varchar(200)
);


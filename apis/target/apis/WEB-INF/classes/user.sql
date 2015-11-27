create table user (id varchar (128) PRIMARY KEY not null,
owner varchar (225) not null,name varchar(225) not null,
password varchar (128) not null, email varchar(225) not null,
updated_date date not null, is_active varchar(1) not null, 
updated_by varchar(225) not null, created_by varchar(225) not null,
created_date date not null);

ALTER TABLE `ng`.`user` 
ADD UNIQUE INDEX `user_name_unique` (`owner` ASC, `name` ASC)  COMMENT '';

ALTER TABLE `ng`.`user` 
ADD UNIQUE INDEX `user_email_unique` (`owner` ASC, `email` ASC)  COMMENT '';

create table user_group (id varchar (128) PRIMARY KEY not null,
owner varchar (225) not null,
name varchar (225) not null, description varchar(4000) not null,
updated_date date not null, is_active varchar(1) not null, 
updated_by varchar(225) not null, created_by varchar(225) not null,
created_date date not null);

ALTER TABLE `ng`.`user_group` 
ADD UNIQUE INDEX `user_group_unique` (`owner` ASC, `name` ASC)  COMMENT '';

create table x_user_group (id varchar (128) PRIMARY KEY not null,
owner varchar (225) not null,user_id varchar(128) not null, 
user_group_id varchar(128) not null, 
updated_date date not null, is_active varchar(1) not null, 
updated_by varchar(225) not null, created_by varchar(225) not null,
created_date date not null);


ALTER TABLE `ng`.`x_user_group` 
ADD UNIQUE INDEX `x_user_group_unique` (`owner` ASC, `user_id` ASC, `user_group_id` ASC)  COMMENT '';


create table user_resource (id varchar (128) PRIMARY KEY not null,
owner varchar (225) not null,owner_id varchar(128) not null, 
owner_type varchar(225) not null, resource_id varchar(128) not null, 
updated_date date not null, is_active varchar(1) not null, 
updated_by varchar(225) not null, created_by varchar(225) not null,
created_date date not null);


ALTER TABLE `ng`.`user_resource` 
ADD UNIQUE INDEX `user_resource_unique` (`owner` ASC, `owner_id` ASC, `owner_type` ASC, `resource_id` ASC)  COMMENT '';

create table contact (id varchar (128) PRIMARY KEY not null,
owner varchar (225) not null,user_id varchar(128) not null, 
first_name varchar(225) not null, middle_name varchar(225) not null, 
last_name varchar(225) not null,email varchar(225) not null,
phone varchar(30) not null,address1 varchar(225) not null,
address2 varchar(225) not null,city varchar(50) not null,
state varchar(50) not null,
country varchar(50) not null,zip varchar(30) not null,
updated_date date not null, is_active varchar(1) not null, 
updated_by varchar(225) not null, created_by varchar(225) not null,
created_date date not null);

create table user_sessions (owner varchar (225) not null,user_name varchar(225) not null, 
expiration_date Date not null, status varchar(10) not null, session_id varchar(20) not null,
action_by_ip varchar(20) not null,
updated_date date not null, is_active varchar(1) not null, 
updated_by varchar(225) not null, created_by varchar(225) not null,
created_date date not null);

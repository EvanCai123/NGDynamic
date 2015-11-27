---Create DB
create database ng;

---Create table Entity
create table entity (owner varchar (225) not null,name varchar(225) not null,
table_name varchar (128) not null, alias varchar(225) not null,
description VARCHAR(4000) NULL,
updated_date date not null, is_active varchar(1) not null, 
updated_by varchar(225) not null, created_by varchar(225) not null,
created_date date not null);

---Add primary key
ALTER TABLE `ng`.`entity` 
ADD PRIMARY KEY (`owner`, `name`)  COMMENT '';



---create table entity_fields
create table entity_fields (owner varchar (225) not null,entity_name varchar (225) not null,
name varchar(225) not null,alias varchar(225) not null,
type VARCHAR(30) NOT NULL, value VARCHAR(4000) NULL,
is_dropdown VARCHAR(1) NOT NULL,
is_nullable VARCHAR(1) NOT NULL,description VARCHAR(4000) NULL,
help_text VARCHAR(45) NULL,length INT NULL,
updated_date date not null, is_active varchar(1) not null, 
updated_by varchar(225) not null, created_by varchar(225) not null,
created_date date not null);

----Create unique index
ALTER TABLE `ng`.`entity_fields` 
ADD PRIMARY KEY (`owner`, `entity_name`, `name`)  COMMENT '';

---Create fk between entity and entity_fields
ALTER TABLE `ng`.`entity_fields` 
ADD CONSTRAINT `field_fk`
  FOREIGN KEY (`owner` , `entity_name`)
  REFERENCES `ng`.`entity` (`owner` , `name`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


---Create dropdwon values 
create table entity_field_values (owner varchar (225) not null,entity_name varchar (225) not null,field_name varchar(128) not null,value varchar(4000) not null,
updated_date date not null, is_active varchar(1) not null, 
updated_by varchar(225) not null, created_by varchar(225) not null,
created_date date not null);


---Create fk with entity_fields table.
ALTER TABLE `ng`.`entity_field_values` 
ADD INDEX `entity_field_value_fk_idx` (`owner` ASC, `entity_name` ASC, `field_name` ASC)  COMMENT '';
ALTER TABLE `ng`.`entity_field_values` 
ADD CONSTRAINT `entity_field_value_fk`
  FOREIGN KEY (`owner` , `entity_name` , `field_name`)
  REFERENCES `ng`.`entity_fieds` (`owner` , `entity_name` , `name`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

  
---Create entity relationship
create table entity_relation (owner varchar (225) not null, parent_entity_name varchar (225) not null,
child_entity_name varchar (225) not null, relationship varchar(30) not null,
parent_field_id varchar (128) not null, child_feild_id varchar (225) not null,
updated_date date not null, is_active varchar(1) not null, 
updated_by varchar(225) not null, created_by varchar(225) not null,
created_date date not null);

ALTER TABLE `ng`.`entity_relation` 
ADD UNIQUE INDEX `relation_unique` (`owner` ASC, `parent_entity_name` ASC, `child_entity_name` ASC, `parent_field_id` ASC, `child_feild_id` ASC)  COMMENT '';



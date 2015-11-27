id varchar (128) PRIMARY KEY not null

---Create DB
create database ng;

---Create table Entity
create table entity (id varchar (128) PRIMARY KEY not null,
owner varchar (225) not null,name varchar(225) not null,
table_name varchar (128) not null, alias varchar(225) not null,
description VARCHAR(4000) NULL,
updated_date date not null, is_active varchar(1) not null, 
updated_by varchar(225) not null, created_by varchar(225) not null,
created_date date not null);

---Add unique index
ALTER TABLE `ng`.`entity` 
ADD UNIQUE INDEX `entity_unique` (`owner` ASC, `name` ASC)  COMMENT '';




---create table entity_fields
create table entity_fields (id varchar (128) PRIMARY KEY not null, 
entity_id varchar (128) not null, owner varchar (225) not null,
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
ADD UNIQUE INDEX `field_unique` (`owner` ASC, `entity_id` ASC, `name` ASC)  COMMENT '';


---Create fk between entity and entity_fields
ALTER TABLE `ng`.`entity_fields` 
ADD INDEX `field_fk_idx` (`entity_id` ASC)  COMMENT '';
ALTER TABLE `ng`.`entity_fieds` 
ADD CONSTRAINT `field_fk`
  FOREIGN KEY (`entity_id`)
  REFERENCES `ng`.`entity` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;



---Create dropdwon values 
create table entity_field_values (id varchar (128) PRIMARY KEY not null, owner varchar (225) not null,
field_id varchar (128) not null,value varchar(4000) not null,
updated_date date not null, is_active varchar(1) not null, 
updated_by varchar(225) not null, created_by varchar(225) not null,
created_date date not null);


---Create fk with entity_fields table.
ALTER TABLE `ng`.`entity_field_values` 
ADD INDEX `value_fk_idx` (`field_id` ASC)  COMMENT '';
ALTER TABLE `ng`.`entity_field_values` 
ADD CONSTRAINT `value_fk`
  FOREIGN KEY (`field_id`)
  REFERENCES `ng`.`entity_fieds` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


  
---Create entity relationship
create table entity_relation (id varchar (128) PRIMARY KEY not null, owner varchar (225) not null, parent_entity_id varchar (225) not null,
child_entity_id varchar (225) not null, relationship varchar(30) not null,
updated_date date not null, is_active varchar(1) not null, 
updated_by varchar(225) not null, created_by varchar(225) not null,
created_date date not null);

ALTER TABLE `ng`.`entity_relation` 
ADD UNIQUE INDEX `relation_unique` (`owner` ASC, `parent_entity_id` ASC, `child_entity_id` ASC)  COMMENT '';

create table entity_relation_fields (id varchar (128) PRIMARY KEY not null, owner varchar (225) not null, relation_id varchar (128) not null,
parent_field_id varchar (128) not null, child_feild_id varchar (225) not null,
updated_date date not null, is_active varchar(1) not null, 
updated_by varchar(225) not null, created_by varchar(225) not null,
created_date date not null);

ALTER TABLE `ng`.`entity_relation_fields` 
ADD UNIQUE INDEX `relation_field_unique` (`owner` ASC, `relation_id` ASC, `parent_field_id` ASC, `child_feild_id` ASC)  COMMENT '';


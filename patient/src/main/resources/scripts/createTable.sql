create table patient(
id bigint auto_increment, 
name varchar(255),
surname varchar(255),
dob varchar(255),
ssn varchar(255)
);
ALTER TABLE patient ADD CONSTRAINT constr_ID UNIQUE (ssn);
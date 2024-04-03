CREATE TABLE visit (
    id bigint auto_increment,
	visittype varchar(255),
    visitreason varchar(255),
	familyhistory varchar(255),
	patientid bigint NOT NULL,
	date  varchar(255),
	time varchar(255),
    PRIMARY KEY (id )
);
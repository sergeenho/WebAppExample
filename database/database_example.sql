CREATE TABLE Company
( 
	id INTEGER NOT NULL , 
	name VARCHAR (50)
) ;
ALTER TABLE Company ADD CONSTRAINT Company_PK PRIMARY KEY ( id ) ;
  
CREATE TABLE Employee
(
	id       INTEGER NOT NULL ,
	name     VARCHAR (50) ,
	phone    VARCHAR (50) ,
	email    VARCHAR (50) ,
	company_id INTEGER
) ;
ALTER TABLE Employee ADD CONSTRAINT Empoyee_PK PRIMARY KEY ( id ) ;

ALTER TABLE Employee ADD CONSTRAINT Company_FK FOREIGN KEY ( company_id ) REFERENCES Company ( id ) ;

CREATE SEQUENCE company_id_seq;
ALTER TABLE Company ALTER id SET DEFAULT NEXTVAL('company_id_seq');

CREATE SEQUENCE employee_id_seq;
ALTER TABLE Employee ALTER id SET DEFAULT NEXTVAL('employee_id_seq');
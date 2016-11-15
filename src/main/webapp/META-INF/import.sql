--Sample data for Table Pereson
insert into hvp.person 
	(id, first_name, last_name, dob, email, zip, state, city, country, status)
	values (1, 'Test', 'Admin', '1988-07-23', 'test01@gmail.com', '52557', 'IA', 'Fairfield', 'USA', 1);
	
insert into hvp.person 
	(id, first_name, last_name, dob, email, zip, state, city, country, status)
	values (2, 'Test02', 'V2', '1987-05-02', 'test02@gmail.com', '52557', 'IA', 'Fairfield', 'USA', 1);
	
insert into hvp.person 
	(first_name, last_name, dob, email, zip, state, city, country, status)
	values ('Test03', 'Tester3', '1999-08-01', 'test03@gmail.com', '52556', 'IA', 'Fairfield', 'USA', 1);

insert into hvp.person 
	(first_name, last_name, dob, email, zip, state, city, country, status)
	values ('Test04', 'Volunteer', '1999-08-01', 'test04@gmail.com', '52556', 'IA', 'Fairfield', 'USA', 1);

--Sample data for Table User	
insert into hvp.user (id, username, password, person_id) values (1, 'admin', 'admin', 1);
insert into hvp.user (id, username, password, person_id) values (2, 'volunteer', 'password', 2);

--Sample data for Table Role
insert into hvp.role(id, name, description) values (1, 'Admin', 'Administrator');
insert into hvp.role(id, name, description) values (2, 'Volunteer', 'Can enroll');

--Sample data for Table Beneficiary
insert into hvp.beneficiary(name, description) values ('Certificate', '3month period');
insert into hvp.beneficiary(name, description) values ('Lunch allowance', '');
insert into hvp.beneficiary(name, description) values ('Trip', 'Room and board included');

--Sample data for Table User Role
insert into hvp.user_role(user_role_id, role_id, user_id) values (1, 1, 1);
insert into hvp.user_role(user_role_id, role_id, user_id) values (2, 2, 2);

--Sample data for Table Skill
insert into hvp.skill(description, years) values ('Java', 2);
insert into hvp.skill(description, years) values ('PHP', 1);
insert into hvp.skill(description, years) values ('Python', 1);
insert into hvp.skill(description, years) values ('.Net', 1);

--Sample data for table Project
insert into hvp.project(id, name, status, description, startDate, endDate, location) 
	values (1, 'pro001', 1, 'school', '2016-11-29', '2017-05-15', 'Cambodia');
 
insert into hvp.project(id, name, status, description, startdate, enddate, location) 
	values (2, 'pro002', 1, 'library', '2016-12-23', '2017-11-02', 'USA');






	
	
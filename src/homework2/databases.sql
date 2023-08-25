create table if not exists person(
id varchar(50) not null,
name varchar(30),
phoneNumber varchar(15),
emailAddress varchar(30) not null,
primary key (id, emailAddress)
);

INSERT INTO person (id, name, phoneNumber, emailAddress)
VALUES
    ('776d7e14-4355-11ee-be56-0242ac120002', 'John', '0768585815', 'john@gmail.com'),
    ('7d3fc220-4355-11ee-be56-0242ac120002', 'Jane', '07458985251', 'jane@gmail.com');

create table if not exists address(
addressId varchar(50) not null,
street varchar(30),
city varchar(30),
state varchar(30),
postalCode varchar(15),
country varchar(30),
personId varchar(50),
primary key (addressId),
foreign key (personId) references homework2.person(id)
);

INSERT INTO address (addressId, street, city, state, postalCode, country, personId)
VALUES
    ('d0f88805-f90f-4418-99c5-8b9d07e7e69a', 'Splai 3', 'Bucuresti', 'B', '12345', 'RO', '776d7e14-4355-11ee-be56-0242ac120002'),
    ('d3f2e7bb-0df1-494b-a0f9-8628979922f0', 'Unirii 70b', 'Constanta', 'CT', '56478', 'RO', '7d3fc220-4355-11ee-be56-0242ac120002');

create table if not exists professor(
salary int,
staffNumber int not null,
yearsOfService int,
numberOfClasses int,
primary key (staffNumber)
);

INSERT INTO professor (salary, staffNumber, yearsOfService, numberOfClasses)
VALUES
    (60000, 101, 5, 3),
    (75000, 102, 10, 4),
    (10000, 103, 1, 5);

create table if not exists student(
studentNumber int not null,
averageMark int,
associatedProfessor int,
primary key (studentNumber),
foreign key (associatedProfessor) references homework2.professor(staffNumber)
);

INSERT INTO student (studentNumber, averageMark, associatedProfessor)
VALUES
	(200, 5, 101),
    (201, 8, 101),
    (202, 7, 102);

select name from person where phoneNumber='0768585815';
select * from professor where salary>600;

update professor set salary=6500 where staffNumber=101;
update student set averageMark=9 where studentNumber=202;

delete from student where studentNumber=200 and averageMark=5;
delete from professor where yearsOfService<2;

select s.studentNumber, s.averageMark, p.salary
from student s
inner join professor p on s.associatedProfessor = p.staffNumber;

select p.name, a.street, a.city, a.state, a.country
from person p
left outer join address a on p.id = a.personId
where personId='776d7e14-4355-11ee-be56-0242ac120002';



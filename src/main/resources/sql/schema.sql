create table applicant(id identity primary key, usrname varchar(50), email varchar(50), pass varchar(15));
create table admin(id identity primary key, usrname varchar(50), email varchar(50), pass varchar(50));
create table cv(id identity primary key,fname varchar(30) ,cvlang varchar(11), applicantid bigint, email varchar(50), address varchar(100), dob date, gender varchar(10), nation varchar(30), school varchar(150), gpa float, skill varchar(300),projects varchar(500),foreign key(applicantid) references applicant(id));
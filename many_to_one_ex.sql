create table faculty (
	id serial primary key,
	name varchar(255)
);

create table students (
	id serial primary key,
	name varchar(255),
	faculty_id int references faculty(id)
);

insert into faculty(name) values ('robotechnics');
insert into students(name, faculty_id) values ('Kirill', 1);

select * from faculty where id in (select faculty_id from students);

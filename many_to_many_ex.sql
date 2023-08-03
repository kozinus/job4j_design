create table work_route (
	id serial primary key,
	name varchar(255)
);

create table main_jobs (
	id serial primary key,
	name varchar(255)
);

create table volunteers (
	id serial primary key,
	name varchar(255),
	work_route_id int references work_route(id),
	main_jobs_id int references main_jobs(id)
);

insert into work_route(name) values ('ecology');
insert into main_jobs(name) values ('tester');
insert into volunteers(name, work_route_id, main_jobs_id) values ('Ilya', 1, 1);

select * from main_jobs where id in (select main_jobs_id from volunteers);

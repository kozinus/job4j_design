drop table dogs_owners;

drop table dogs;
create table dogs_types (
	id serial primary key,
	name varchar(255)
);

create table owners_job (
	id serial primary key,
	name varchar(255)
);

create table dogs_owners (
	id serial primary key,
	name varchar(255),
	dog_id int references dogs_types(id),
	job_id int references owners_job(id)
);

insert into dogs_types(name) values ('bulldog');
insert into owners_job(name) values ('tester');
insert into dogs_owners(name, dog_id, job_id) values ('Mark', 1, 1);

select * from owners_job where id in (select job_id from dogs_owners);

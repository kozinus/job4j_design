drop table dogs_owners;
drop table dogs_types;
create table dogs_types (
	id serial primary key,
	name varchar(255)
);

create table dogs_owners (
	id serial primary key,
	name varchar(255),
	dog_id int references dogs_types(id)
);

insert into dogs_types(name) values ('bulldog');
insert into dogs_owners(name, dog_id) values ('Mark', 1);

select * from dogs_types where id in (select dog_id from dogs_owners);

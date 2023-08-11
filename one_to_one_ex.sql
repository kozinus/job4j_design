create table dogs (
	id serial primary key,
	name varchar(255)
);

create table dogs_owners (
	id serial primary key,
	name varchar(255),
	dog_id int references dogs(id) unique
);

insert into dogs(name) values ('Tyson');
insert into dogs_owners(name, dog_id) values ('Mark', 1);

select * from dogs where id in (select dog_id from dogs_owners);

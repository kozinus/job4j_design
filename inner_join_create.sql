create table license(
    id serial primary key,
    category varchar(255),
    number int
);

create table people(
    id serial primary key,
    name varchar(255),
	license_id int references license(id) unique
);
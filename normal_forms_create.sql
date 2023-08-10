create table adresses(
	id serial primary key,
	name varchar(255)
);

create table clients(
	id serial primary key,
	name varchar(40),
	sex bool,
	adress_id int references adresses(id) 
);

create table movies(
	id serial primary key,
	name varchar(40)
);

create table rents(
	id serial primary key,
	client_id int references clients(id)
);

create table rents_movies(
	id serial primary key,
	rent_id int references rents(id),
	movie_id int references movies(id)
);
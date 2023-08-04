create table rules (
	id serial primary key,
	rule varchar(255)
);

create table roles (
	id serial primary key,
	role_name varchar(255),
	rule_id int references rules(id)
);

create table users (
	id serial primary key,
	name varchar(255),
	role_id int references roles(id)
);

create table categories (
	id serial primary key,
	category varchar(255)
);

create table items (
	id serial primary key,
	item_name varchar(255)
);

create table coments (
	id serial primary key,
	comm_content varchar(255)
);

create table attachs (
	id serial primary key,
	files_names varchar(255)
);

create table states (
	id serial primary key,
	state varchar(255)
);
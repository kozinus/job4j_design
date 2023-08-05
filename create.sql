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

create table items_users (
	id serial primary key,
	item_id int references items(id),
	user_id int references users(id)
);

create table items_categories (
	id serial primary key,
	item_id int references items(id),
	category_id int references categories(id)
);

create table items_states (
	id serial primary key,
	item_id int references items(id),
	state_id int references states(id)
);

create table comments_items (
	id serial primary key,
	item_id int references items(id),
	comment_id int references coments(id)
);

create table attachs_items (
	id serial primary key,
	item_id int references items(id),
	attach_id int references attachs(id)
);
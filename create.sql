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
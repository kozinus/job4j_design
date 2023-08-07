create table students (
    id serial primary key,
    name varchar(50)
);

create table authors (
    id serial primary key,
    name varchar(50)
);

create table distributors (
	id serial primary key,
	name varchar(200)
);

create table books (
    id serial primary key,
    name varchar(200),
    author_id integer references authors(id),
	distributor_id integer references distributors(id)
);

create table orders (
    id serial primary key,
    active boolean default true,
    book_id integer references books(id),
    student_id integer references students(id)
);


insert into students (name) values ('Иван Иванов');
insert into students (name) values ('Петр Петров');

insert into authors (name) values ('Александр Пушкин');
insert into authors (name) values ('Николай Гоголь');

insert into distributors (name) values ('Росмэн');
insert into distributors (name) values ('Эксмо');

insert into books (name, author_id, distributor_id) values ('Евгений Онегин', 1, 2);
insert into books (name, author_id, distributor_id) values ('Капитанская дочка', 1, 2);
insert into books (name, author_id, distributor_id) values ('Дубровский', 1, 1);
insert into books (name, author_id, distributor_id) values ('Мертвые души', 2, 1);
insert into books (name, author_id, distributor_id) values ('Вий', 2, 2);

insert into orders (book_id, student_id) values (1, 1);
insert into orders (book_id, student_id) values (3, 1);
insert into orders (book_id, student_id) values (5, 2);
insert into orders (book_id, student_id) values (4, 1);
insert into orders (book_id, student_id) values (2, 2);
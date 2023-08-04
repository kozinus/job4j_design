drop table product;
drop table type;

create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
	type_id int references type(id),
    expired_date date,
	price float
);

insert into type(name) values('СЫР');
insert into type(name) values('МЯСО');
insert into type(name) values('СЛАДОСТИ');

insert into product(name, type_id, expired_date, price)
values('Индейка 500гр', 2, '2023-08-17', 300);
insert into product(name, type_id, expired_date, price)
values('Чеддер', 1, '2023-12-21', 200);
insert into product(name, type_id, expired_date, price)
values('Моцарелла', 1, '2023-10-03', 250);
insert into product(name, type_id, expired_date, price)
values('Говядина 1кг', 2, '2023-08-02', 220);
insert into product(name, type_id, expired_date, price)
values('Пломбир', 3, '2024-08-21', 70);
insert into product(name, type_id, expired_date, price)
values('Фисташковое мороженое', 3, '2023-11-22', 80);
insert into product(name, type_id, expired_date, price)
values('Бабаевский батончик', 3, '2023-05-30', 30);
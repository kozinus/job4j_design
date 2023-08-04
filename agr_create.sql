drop table devices_people;
drop table people;
drop table devices;

create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into people(name) values('Maksim');
insert into people(name) values('Pavel');
insert into people(name) values('Ilya');

insert into devices(name, price)
values ('phone', 22000.96);
insert into devices(name, price)
values ('PC', 72030.55);

insert into devices(name, price)
values ('phone', 32000.96);
insert into devices(name, price)
values ('watch', 12030.55);

insert into devices(name, price)
values ('phone', 42000.96);
insert into devices(name, price)
values ('notebook', 92030.35);
insert into devices(name, price)
values ('TV', 85823);

insert into devices_people(device_id, people_id)
values(1, 1);
insert into devices_people(device_id, people_id)
values(2, 1);
insert into devices_people(device_id, people_id)
values(3, 2);
insert into devices_people(device_id, people_id)
values(4, 2);
insert into devices_people(device_id, people_id)
values(5, 3);
insert into devices_people(device_id, people_id)
values(6, 3);
insert into devices_people(device_id, people_id)
values(7, 3);
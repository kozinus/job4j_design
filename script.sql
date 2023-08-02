create table fish (
	id serial primary key,
	name varchar(255),
	length numeric,
	area text
);
insert into fish(name, length, area) values ('Скумбрия', 0.3, 'Чёрное Море');
select * from fish;
update fish set name = 'Сельдь';
select * from fish;
delete from fish;
select * from fish;
drop table fish;


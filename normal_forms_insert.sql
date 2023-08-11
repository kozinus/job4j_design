insert into adresses(name) 
values
('1-й Казанский переулок, д.14'),
('Ул. Центральная, д.40, кв.74'),
('ул. Ленина, д. 7, кв.130');

insert into clients(name, sex, adress_id) 
values
('Ольга Егорова', true, 1),
('Иванов Сергей', false, 2),
('Иванов Сергей', false, 3);

insert into movies(name) 
values
('Пираты'),
('Человек'),
('Матрица'),
('Интерстеллар');

insert into rents(client_id) 
values
(1),
(2),
(3);

insert into rents_movies(rent_id, movie_id) 
values
(1, 1),
(1, 3),
(2, 2),
(2, 4),
(3, 3);
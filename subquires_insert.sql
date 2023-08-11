insert into customers(first_name,
					 last_name,
					 age,
					 country)
values
('mark','makarov', 20, 'Russia'),
('ilya','makarov', 18, 'Russia'),
('andrej','makarov', 23, 'Russia'),
('kirill','makarov', 25, 'Russia');

insert into orders(amount, customer_id)
values
(0, 1),
(6, 2),
(0, 3),
(3, 4);
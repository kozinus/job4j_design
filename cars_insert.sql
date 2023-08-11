insert into car_bodies(name)
values
('Sedan'),
('Hatchback'),
('Crossover'),
('Offroad');

insert into car_engines(name)
values
('diesel 2.0'),
('petrol 2.0'),
('petrol 1.4'),
('diesel 3.0');

insert into car_transmissions(name)
values
('DSG'),
('ZF'),
('Manual');

insert into cars(name, body_id, engine_id, transmission_id)
values
('VW POLO', 1, 3, 1),
('AUDI Q5d', 3, 1, 2),
('AUDI A3 2006', 1, 3, 1),
('AUDI A3 2012', 2, 3, 1),
('VW TIGUAN', 3, 2, null),
('VW TOUAREG', 3, null, 2);
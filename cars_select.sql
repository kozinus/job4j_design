select c.id, c.name, cb.name, ce.name, ct.name
from
cars c left join car_bodies cb on c.body_id = cb.id
left join car_engines ce on c.engine_id = ce.id
left join car_transmissions ct on c.transmission_id = ct.id;

select cb.name
from
car_bodies cb left join cars c on cb.id = c.body_id
group by cb.name
having count(c.id) = 0;

select ce.name
from
car_engines ce left join cars c on ce.id = c.engine_id
group by ce.name
having count(c.id) = 0;

select ct.name
from
car_transmissions ct left join cars c on ct.id = c.transmission_id
group by ct.name
having count(c.id) = 0;
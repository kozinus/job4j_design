select avg(d.price)
from devices_people as ds
join devices d
on ds.device_id = d.id;

select p.name, avg(d.price)
from devices_people as ds
join devices d
on ds.device_id = d.id
join people p
on ds.people_id = p.id
group by p.name;

select p.name, avg(d.price)
from devices_people as ds
join devices d
on ds.device_id = d.id
join people p
on ds.people_id = p.id
group by p.name
having avg(d.price) > 50000;
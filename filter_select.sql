select t.name "Тип", p.name "Название", p.expired_date, p.price
from product as p
join type as t
on p.type_id = t.id
where t.name like 'СЫР';

select t.name "Тип", p.name "Название", p.expired_date, p.price
from product as p
join type as t
on p.type_id = t.id
where p.name like '%мороженое%';

select t.name "Тип", p.name "Название", p.expired_date, p.price
from product as p
join type as t
on p.type_id = t.id
where (select current_date) > p.expired_date;

select t.name "Тип", p.name "Название", p.expired_date, p.price
from product as p
join type as t
on p.type_id = t.id
order by p.price desc
limit 1;

select t.name "Тип", count(p.id)
from product as p
join type as t
on p.type_id = t.id
group by t.name;

select t.name "Тип", p.name "Название", p.expired_date, p.price
from product as p
join type as t
on p.type_id = t.id
where t.name like 'СЫР' or t.name like 'СЛАДОСТИ';

select t.name "Тип", p.name "Название", p.expired_date, p.price
from product as p
join type as t
on p.type_id = t.id;

select t.name "Тип", count(p.id)
from product as p
join type as t
on p.type_id = t.id
group by t.name
having count(p.id) < 3;
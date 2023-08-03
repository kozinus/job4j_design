select p.name, l.category, l.number
from people as p join license as l on p.license_id = l.id;

select p.name as "Имя", l.category as "Категория", l.number as "Номер"
from people as p inner join license as l on p.license_id = l.id;

select p.name Имя, l.category Категория, l.number Номер
from people as p join license as l on p.license_id = l.id;
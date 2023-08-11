select * from employees e left join departments d on e.dep_id = d.id;
select * from employees e right join departments d on e.dep_id = d.id;
select * from employees e cross join departments d;

select d.name from departments d left join employees e on e.dep_id = d.id
group by d.name having count(e.name) = 0;

select * from departments d left join employees e on e.dep_id = d.id;
select d.id, d.name, e.id, e.name, e.dep_id from employees e right join departments d on e.dep_id = d.id;
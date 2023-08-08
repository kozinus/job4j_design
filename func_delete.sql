insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
create or replace procedure delete_data_p(u_count integer)
language 'plpgsql'
as $$
    BEGIN
		if u_count is not null then
        	delete from products where count <= u_count;
		end if;
    END;
$$;

create or replace function delete_data_f(u_count integer)
returns integer
language 'plpgsql'
as $$
	declare
		result integer;
    BEGIN
		select into result count(name) from products;
		if u_count is not null then
        	delete from products where count <= u_count;
		end if;
		select into result (result - (select count(name) from products));
		return result;
    END;
$$;
delete from products;
insert into products (name, producer, count, price)
VALUES
('product_1', 'producer_1', 3, 50);
insert into products (name, producer, count, price)
VALUES
('product_2', 'producer_1', 7, 50);
insert into products (name, producer, count, price)
VALUES
('product_3', 'producer_1', 4, 50);
insert into products (name, producer, count, price)
VALUES
('product_1', 'producer_1', 17, 50);

select delete_data_f(5);
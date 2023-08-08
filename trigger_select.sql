create or replace function pre_tax()
    returns trigger as
$$
    BEGIN
        new.price = new.price + new.price * 0.2;
		return new;
    END;
$$
LANGUAGE 'plpgsql';

create or replace function post_tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.2
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create or replace function post_store()
    returns trigger as
$$
    BEGIN
		insert into history_of_price(name, price, date)
		values
		(new.name,
		new.price,
		current_timestamp);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create or replace trigger store_trigger
    after insert on products
    for each row
    execute procedure post_store();

create or replace trigger post_tax_trigger
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure post_tax();

	
create or replace trigger pre_tax_trigger
    before insert on products
    for each row
    execute procedure pre_tax();

	


insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);
select * from products;
select * from history_of_price;
select * from customers
where id not in (select customer_id from orders
				where amount > 0);
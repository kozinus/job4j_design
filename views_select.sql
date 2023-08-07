select d.name, count(s.name), s.name from students as s
    join orders o on s.id = o.student_id
    join books b on o.book_id = b.id
    join authors a on b.author_id = a.id
	join distributors d on b.distributor_id = d.id
    group by (d.name, s.name) having count(s.name) >= 2;
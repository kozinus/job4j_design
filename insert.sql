insert into rules(rule) values ('Rule #1');
insert into roles(role_name) values ('admin');
insert into users(name, role_id) values ('Mark', 1);
insert into states(state) values ('ok');
insert into categories(category) values ('databases');
insert into items(item_name, user_id, category_id, state_id)
values ('client database', 1, 1, 1);
insert into attachs(files_names, item_id) values ('db.sql', 1);
insert into comments(comm_content, item_id) values ('accepted', 1);
insert into roles_rules(role_id, rule_id) values (1, 1);
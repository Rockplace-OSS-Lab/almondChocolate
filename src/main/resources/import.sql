insert into user (user_seq, email, password, status) values (1, 'javajigi@slipp.net', 'test', 1);
insert into user (user_seq, email, password, status) values (2, 'sanjigi@slipp.net', 'test', 1);

insert into user_role (user_id, role) values (1, 'ROLE_USER');
insert into user_role (user_id, role) values (2, 'ROLE_USER');
insert into user_role (user_id, role) values (2, 'ROLE_ADMIN');
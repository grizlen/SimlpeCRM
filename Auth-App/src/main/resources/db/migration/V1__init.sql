create table roles (id serial not null constraint roles_id_pk primary key, name varchar(20) not null unique);

create table users (id bigserial not null constraint users_id_pk primary key, login varchar(50) unique, password varchar(500));

create table users_roles(user_id bigint references users(id), role_id int references roles(id));

create table user_details (
    id: bigserial not null constraint user_details_id_pk primary key,
    user_id bigint references user(id),
    first_name varchar(50),
    last_name varchar(50),
    sure_name varchar(50),
    phone varchar(15),
    address varchar(100));

insert into roles(name) values
('ROLE_ADMIN'),
('ROLE_USER');

insert into users(login, password) values
('user1', '$2a$10$EtT1PhtYiLi1OfDrK/j7cu1ul0ctnZOPoAkzu7myavf7BucWMCN9W');

insert into users_roles(user_id, role_id) values
(1, 2);

insert into user_details(user_id) values
(1);
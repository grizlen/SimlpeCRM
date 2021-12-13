CREATE TABLE roles (
    id SERIAL NOT NULL CONSTRAINT roles_id_pk PRIMARY KEY,
    name VARCHAR(20) NOT NULL UNIQUE);

CREATE TABLE users (
    id BIGSERIAL NOT NULL CONSTRAINT users_id_pk PRIMARY KEY,
    login VARCHAR(50) UNIQUE,
    password VARCHAR(500));

CREATE TABLE users_roles(
    user_id BIGINT references users(id),
    role_id INT references roles(id));

CREATE TABLE user_details (
    id BIGSERIAL NOT NULL CONSTRAINT user_details_id_pk PRIMARY KEY,
    user_id BIGINT NOT NULL UNIQUE,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    sure_name VARCHAR(50),
    phone VARCHAR(15),
    address VARCHAR(100));

CREATE TABLE products (
    id BIGSERIAL NOT NULL CONSTRAINT products_id_pk PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price INT NOT NULL);

INSERT INTO roles(name)
    VALUES
        ('ROLE_ADMIN'),
        ('ROLE_USER');

INSERT INTO users(login, password)
    VALUES
        ('user1', '$2a$10$EtT1PhtYiLi1OfDrK/j7cu1ul0ctnZOPoAkzu7myavf7BucWMCN9W');

INSERT INTO users_roles(user_id, role_id)
    VALUES
        (1, 2);

INSERT INTO user_details(user_id)
    VALUES
        (1);

INSERT INTO products (title, price)
    VALUES
        ('Хлеб', 24),
        ('Молоко', 65),
        ('Сыр', 320),
        ('Макароны', 100),
        ('Сахар', 50),
        ('соль', 20),
        ('Майонез', 150),
        ('Колбаса', 150);

CREATE TABLE product (
  `id` bigserial PRIMARY KEY,
  `title` varchar(255) NOT NULL,
  `price` int NOT NULL
);

insert into product (title, price)
values
('Хлеб', 24),
('Молоко', 65),
('Сыр', 320),
('Макароны', 100),
('Сахар', 50),
('соль', 20),
('Майонез', 150),
('Колбаса', 150);

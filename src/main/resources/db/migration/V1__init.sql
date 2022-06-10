create table products(
    id bigserial primary key,
    title varchar(255),
    price int
);

insert into products(title, price)
values
    ('Milk', 100),
    ('Sauce', 234),
    ('Pizza', 500),
    ('Bread', 50),
    ('Pork', 578),
    ('Chicken', 456),
    ('Cream', 210),
    ('Vine', 800),
    ('Sugar', 80),
    ('Salt', 40),
    ('Chocolate', 150),
    ('Sausages', 600),
    ('Oil', 112),
    ('Black_caviar', 3200),
    ('Spaghetti', 170);
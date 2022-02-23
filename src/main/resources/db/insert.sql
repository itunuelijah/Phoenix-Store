set foreign_key_checks = 0; -- not for postgres

truncate table product; ----  truncate table product cascade ; for postgres db
truncate table item;
truncate table cart;
truncate table cart_item_list;
truncate table app_user;


insert into product(id, name, price, quantity)
values(12, 'Luxury Mop', 2340, 3),
(13, 'Macbook Air', 500, 4),
(14, 'Rocking chair', 5340, 5),
(15, 'Purple T-shirt', 7340, 7);

insert into item(id, product_id, quantity_added_to_cart)
values(510, 14, 2),
(511, 15, 3),
(512, 12, 1);

insert into cart(id, total_price)
values(345, 0.0),
(355, 0.0),
(366, 0.0),
(377, 0.0);

insert into app_user(id, firstname, lastname, email, my_cart_id)
values(5005, 'John', 'Badmus', 'john@myspace.com', 345),
      (5010, 'Chris', 'Tuck', 'chris@myspace.com',355),
      (5011, 'GoodNews', 'Confidence', 'goodconfidence@myspace.com', 366);


insert into cart_item_list(cart_id, item_list_id)
values(345, 510),
(366, 512),
(355, 511);



set foreign_key_checks = 1;


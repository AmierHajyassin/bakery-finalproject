use bakery;

SELECT * FROM customer;
SELECT * FROM baked_goods;
SELECT * FROM orders;
SELECT * FROM order_info; 

DELETE FROM customer;
DELETE FROM orders;
DELETE FROM baked_goods;
DELETE FROM order_info;

DROP TABLE IF EXISTS order_info;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS baked_goods;
DROP TABLE IF EXISTS customer;


CREATE TABLE customer(
    customer_name VARCHAR(128) NOT NULL,
    customer_phoneNum VARCHAR(10) NOT NULL,
    customer_email VARCHAR(128) NOT NULL,
    PRIMARY KEY (customer_name)
);

CREATE TABLE baked_goods(
    baked_goods_id INT AUTO_INCREMENT NOT NULL,
    baked_goods ENUM('baklava','chocolate cupcakes',
                    'vanilla cupcakes', 'red velvet cupcakes',
                    'cannoli', 'kanafeh', 'harissa','qatayef',
                    'assorted baked goods'),
    PRIMARY KEY (baked_goods_id)
);

CREATE TABLE orders(
    order_number INT AUTO_INCREMENT NOT NULL,
    customer_name VARCHAR(128) NOT NULL,
    baked_goods_id INT NOT NULL, 
    quantity ENUM('Half Dozen','Bakers Dozen','Two Dozen', 'Three Dozen'),
    PRIMARY KEY(order_number),
    FOREIGN KEY(customer_name) REFERENCES customer (customer_name) ON DELETE CASCADE,
    FOREIGN KEY(baked_goods_id) REFERENCES baked_goods (baked_goods_id) ON DELETE CASCADE
);

CREATE TABLE order_info(
	order_number INT AUTO_INCREMENT NOT NULL,
	baked_goods_id INT NOT NULL,
    order_status enum('ORDER RECEIVED','IN THE OVEN', 'READY FOR PICKUP'),
    order_total decimal(4, 2) NOT NULL,
    FOREIGN KEY(baked_goods_id) REFERENCES baked_goods (baked_goods_id) ON DELETE CASCADE,
    FOREIGN KEY(order_number) REFERENCES orders (order_number) ON DELETE CASCADE,
    UNIQUE KEY(order_number, baked_goods_id)
    
);


insert into customer (customer_name, customer_phoneNum, customer_email) values ('Amier Hajyassin',  '9094221176',  'amierhajyassin@yahoo.com');
insert into customer (customer_name, customer_phoneNum, customer_email) values ('Amjad Hajyassin',  '3477654321',  'amjadhajyassin@gmail.com');
insert into customer (customer_name, customer_phoneNum, customer_email) values ('Amany Hajyassin',  '2127649090',  'amanyhajyassin@gamil.com');
insert into customer (customer_name, customer_phoneNum, customer_email) values ('Ameen Hajyassin',  '7187641010',  'ameenhajyassin@gmail.com');
insert into customer (customer_name, customer_phoneNum, customer_email) values ('Joe Blaine', 	    '5156789027',  'joeblaine@yahoo.com');
insert into customer (customer_name, customer_phoneNum, customer_email) values ('Moe Marie', 	    '5123427980',  'moemarie@yahoo.com');
insert into customer (customer_name, customer_phoneNum, customer_email) values ('Randa Marie', 	    '3057896543',  'randamarie@gmail.com');
insert into customer (customer_name, customer_phoneNum, customer_email) values ('Anna Jonhson',     '3132004400',  'annajonhson@yahoo.com');
insert into customer (customer_name, customer_phoneNum, customer_email) values ('Anthony Davis',    '6164445555',  'anthonydavis@yahoo.com');
insert into customer (customer_name, customer_phoneNum, customer_email) values ('Michael Kay',      '3479193776',  'michaelkay@gmail.com');

INSERT into baked_goods (baked_goods) values ('Baklava');
INSERT into baked_goods (baked_goods) values ('Chocolate Cupcakes');
INSERT into baked_goods (baked_goods) values ('Vanilla Cupcakes');
INSERT into baked_goods (baked_goods) values ('Red Velvet Cupcakes');
INSERT into baked_goods (baked_goods) values ('Cannoli');
INSERT into baked_goods (baked_goods) values ('Kanafeh');
INSERT into baked_goods (baked_goods) values ('Harissa');
INSERT into baked_goods (baked_goods) values ('Atayek');
INSERT into baked_goods (baked_goods) values ('Assorted Baked Goods');

INSERT into orders(customer_name, baked_goods_id, quantity) values ('Amany Hajyassin',   '8',  'Bakers Dozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Amjad Hajyassin',   '6',  'Half Dozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Ameen Hajyassin',   '3',  'Three Dozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Amier Hajyassin',   '7',  'Bakers Dozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Randa Marie',       '2',  'Bakers Dozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Joe Blaine',        '9',  'Two Dozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Moe Marie',         '4',  'Two Dozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Anna Jonhson',	     '1',  'Bakers Dozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Anthony Davis',     '5',  'Half Dozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Michael Kay',       '4',  'Bakers Dozen');

INSERT into order_info (baked_goods_id, order_status, order_total) values('8', 'IN THE OVEN',       '24.99');
INSERT into order_info (baked_goods_id, order_status, order_total) values('6', 'READY FOR PICKUP',  '12.99');
INSERT into order_info (baked_goods_id, order_status, order_total) values('3', 'IN THE OVEN',       '71.99');
INSERT into order_info (baked_goods_id, order_status, order_total) values('7', 'ORDER RECEIVED',    '24.99');
INSERT into order_info (baked_goods_id, order_status, order_total) values('2', 'READY FOR PICKUP',  '24.99');
INSERT into order_info (baked_goods_id, order_status, order_total) values('9', 'ORDER RECEIVED',    '48.99');
INSERT into order_info (baked_goods_id, order_status, order_total) values('4', 'IN THE OVEN',       '48.99');
INSERT into order_info (baked_goods_id, order_status, order_total) values('1', 'READY FOR PICKUP',  '24.99');
INSERT into order_info (baked_goods_id, order_status, order_total) values('5', 'ORDER RECEIVED',    '12.99');
INSERT into order_info (baked_goods_id, order_status, order_total) values('4', 'READY FOR PICKUP',  '24.99');






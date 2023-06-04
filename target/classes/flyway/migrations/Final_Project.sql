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
    baked_goods ENUM('baklava','chocolatecupcakes',
                    'vanillacupcakes', 'redvelvetcupcakes',
                    'cannoli', 'kanafeh', 'harissa', 'qatayef',
                    'assortedbakedgoods'),
    PRIMARY KEY (baked_goods_id)
);

CREATE TABLE orders(
	order_number INT AUTO_INCREMENT NOT NULL,
    customer_name VARCHAR(128) NOT NULL,
    baked_goods_id INT NOT NULL,
    quantity ENUM('HalfDozen','BakersDozen','TwoDozen', 'ThreeDozen'),
    PRIMARY KEY(order_number),
    FOREIGN KEY(customer_name) REFERENCES customer (customer_name) ON DELETE CASCADE,
    FOREIGN KEY(baked_goods_id) REFERENCES baked_goods (baked_goods_id) ON DELETE CASCADE
);

CREATE TABLE order_info(
	order_number INT AUTO_INCREMENT NOT NULL,
	baked_goods_id INT NOT NULL,
    total decimal(4, 2) NOT NULL,
 	order_status enum('ORDERRECEIVED','INTHEOVEN', 'READYFORPICKUP'),
    FOREIGN KEY(baked_goods_id) REFERENCES baked_goods (baked_goods_id) ON DELETE CASCADE,
    FOREIGN KEY(order_number) REFERENCES orders (order_number) ON DELETE CASCADE,
    UNIQUE KEY(order_number, baked_goods_id)
    
);


INSERT into customer (customer_name, customer_phoneNum, customer_email) values ('Amier Hajyassin',  '9094221176',  'amierhajyassin@yahoo.com');
INSERT into customer (customer_name, customer_phoneNum, customer_email) values ('Amjad Hajyassin',  '3477654321',  'amjadhajyassin@gmail.com');
INSERT into customer (customer_name, customer_phoneNum, customer_email) values ('Amany Hajyassin',  '2127649090',  'amanyhajyassin@gamil.com');
INSERT into customer (customer_name, customer_phoneNum, customer_email) values ('Ameen Hajyassin',  '7187641010',  'ameenhajyassin@gmail.com');
INSERT into customer (customer_name, customer_phoneNum, customer_email) values ('Joe Blaine', 	    '5156789027',  'joeblaine@yahoo.com');
INSERT into customer (customer_name, customer_phoneNum, customer_email) values ('Moe Marie', 	    '5123427980',  'moemarie@yahoo.com');
INSERT into customer (customer_name, customer_phoneNum, customer_email) values ('Randa Marie', 	    '3057896543',  'randamarie@gmail.com');
INSERT into customer (customer_name, customer_phoneNum, customer_email) values ('Anna Jonhson',     '3132004400',  'annajonhson@yahoo.com');
INSERT into customer (customer_name, customer_phoneNum, customer_email) values ('Anthony Davis',    '6164445555',  'anthonydavis@yahoo.com');
INSERT into customer (customer_name, customer_phoneNum, customer_email) values ('Michael Kay',      '3479193776',  'michaelkay@gmail.com');

INSERT into baked_goods (baked_goods) values ('baklava');
INSERT into baked_goods (baked_goods) values ('chocolatecupcakes');
INSERT into baked_goods (baked_goods) values ('vanillacupcakes');
INSERT into baked_goods (baked_goods) values ('redvelvetcupcakes');
INSERT into baked_goods (baked_goods) values ('cannoli');
INSERT into baked_goods (baked_goods) values ('kanafeh');
INSERT into baked_goods (baked_goods) values ('harissa');
INSERT into baked_goods (baked_goods) values ('qatayef');
INSERT into baked_goods (baked_goods) values ('assortedbakedgoods');

INSERT into orders(customer_name, baked_goods_id, quantity) values ('Amany Hajyassin',   '8',  'BakersDozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Amjad Hajyassin',   '6',  'HalfDozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Ameen Hajyassin',   '3',  'ThreeDozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Amier Hajyassin',   '7',  'BakersDozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Randa Marie',       '2',  'BakersDozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Joe Blaine',        '9',  'TwoDozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Moe Marie',         '4',  'TwoDozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Anna Jonhson',	     '1',  'BakersDozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Anthony Davis',     '5',  'HalfDozen');
INSERT into orders(customer_name, baked_goods_id, quantity) values ('Michael Kay',       '4',  'BakersDozen');

INSERT into order_info (baked_goods_id, order_status, total) values('8', 'INTHEOVEN',       '24.99');
INSERT into order_info (baked_goods_id, order_status, total) values('6', 'READYFORPICKUP',  '12.99');
INSERT into order_info (baked_goods_id, order_status, total) values('3', 'INTHEOVEN',       '71.99');
INSERT into order_info (baked_goods_id, order_status, total) values('7', 'ORDERRECEIVED',    '24.99');
INSERT into order_info (baked_goods_id, order_status, total) values('2', 'READYFORPICKUP',  '24.99');
INSERT into order_info (baked_goods_id, order_status, total) values('9', 'ORDERRECEIVED',    '48.99');
INSERT into order_info (baked_goods_id, order_status, total) values('4', 'INTHEOVEN',       '48.99');
INSERT into order_info (baked_goods_id, order_status, total) values('1', 'READYFORPICKUP',  '24.99');
INSERT into order_info (baked_goods_id, order_status, total) values('5', 'ORDERRECEIVED',    '12.99');
INSERT into order_info (baked_goods_id, order_status, total) values('4', 'READYFORPICKUP',  '24.99');






use bakery;

SELECT * FROM customer;
SELECT * FROM baked_goods;
SELECT * FROM orders;
SELECT * FROM order_info; 

DELETE FROM customer;
DELETE FROM orders;


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
                    'cannoli', 'kanafeh', 'harissa','atayek',
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
    baked_goods_id INT NOT NULL,
    order_number INT NOT NULL,
    order_status enum('ORDER RECEIVED','IN THE OVEN', 'READY FOR PICKUP'),
    FOREIGN KEY(baked_goods_id) REFERENCES baked_goods (baked_goods_id) ON DELETE CASCADE,
    FOREIGN KEY(order_number) REFERENCES orders (order_number) ON DELETE CASCADE,
    UNIQUE KEY(order_number, baked_goods_id)
    
);

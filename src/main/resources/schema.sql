-- 各種テーブル削除
DROP VIEW  IF EXISTS v_order_details;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS items CASCADE;
DROP TABLE IF EXISTS customers CASCADE;
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS order_details CASCADE;

-- カテゴリーテーブル
CREATE TABLE categories
(
   id SERIAL PRIMARY KEY,
   name TEXT
);
-- 商品テーブル
CREATE TABLE items
(
   id SERIAL PRIMARY KEY,
   category_id INTEGER,
   name TEXT,
   price INTEGER
);
-- 顧客テーブル
CREATE TABLE customers
(
   id SERIAL PRIMARY KEY,
   name TEXT,
   address TEXT,
   tel TEXT,
   email TEXT
);
-- 注文テーブル
CREATE TABLE orders
(
   id SERIAL PRIMARY KEY,
   customer_id INTEGER,
   ordered_on DATE,
   total_price INTEGER
   
);
-- 注文明細テーブル
CREATE TABLE order_details
(
   id SERIAL PRIMARY KEY,
   order_id INTEGER,
   item_id INTEGER,
   quantity INTEGER
);

-- 注文明細詳細ビュウ
CREATE VIEW v_order_details AS (
	SELECT
		details.id AS id,
		items.id AS item_id,
		items.name AS name,
		items.price AS price,
		details.quantity AS quantity,
		items.price * details.quantity AS subtotal,
		orders.customer_id AS customer_id
	FROM order_details details
	JOIN orders ON details.order_id = orders.id
	JOIN items ON details.item_id = items.id
);


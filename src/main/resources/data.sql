-- カテゴリーテーブルデータ
INSERT INTO categories(name) VALUES('本');
INSERT INTO categories(name) VALUES('DVD');
INSERT INTO categories(name) VALUES('ゲーム');
-- 商品テーブルデータ
INSERT INTO items(category_id, name, price) VALUES(1, 'Javaの基本', 2500);
INSERT INTO items(category_id, name, price) VALUES(1, 'MLB Fun', 980);
INSERT INTO items(category_id, name, price) VALUES(1, '料理BOOK!', 1200);
INSERT INTO items(category_id, name, price) VALUES(2, 'なつかしのアニメシリーズ', 2000);
INSERT INTO items(category_id, name, price) VALUES(2, 'The Racer', 1000);
INSERT INTO items(category_id, name, price) VALUES(2, 'Space Wars 3', 1800);
INSERT INTO items(category_id, name, price) VALUES(3, 'パズルゲーム', 780);
INSERT INTO items(category_id, name, price) VALUES(3, 'Invader Fighter', 3400);
INSERT INTO items(category_id, name, price) VALUES(3, 'Play the BasketBall', 2200);
-- 顧客テーブルデータ（SP90課題追加）
INSERT INTO customers (name, address, tel, email) VALUES
 ('田中太郎', '東京', '090-1111-1111', 'tanaka@aaa.com'),
 ('鈴木一郎', '大阪', '090-2222-2222', 'suzuki@aaa.com'),
 ('徳川光圀', '茨城県水戸市', '029-1628-1701', 'goroukou@tokugawa.gov');
-- 注文テーブルデータ（SP90課題追加）
INSERT INTO orders (customer_id, ordered_on, total_price) VALUES
 (1, '2025-01-02', 5980),
 (2, '2025-03-29', 1000),
 (3, '2025-04-10', 15860);
-- (2, 2, );
-- 注文明細テーブルデータ（SP90課題追加）
INSERT INTO order_details (order_id, item_id, quantity) VALUES
 (1, 1, 2),
 (1, 2, 1),
 (2, 5, 1),
 (3, 1, 1),
 (3, 2, 1),
 (3, 3, 1),
 (3, 4, 1),
 (3, 5, 1),
 (3, 6, 1),
 (3, 7, 1),
 (3, 8, 1),
 (3, 9, 1);
 
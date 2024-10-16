truncate table products restart identity cascade;
truncate table order_lines restart identity cascade;

insert into products (id, name, description, image, price, stock, type) VALUES
(1, 'Beurre d’érable', 'Une description interessante qui donne envie d''acheter ce sirop qui me semble fort bon', 'https://www.sucrerieblouin.com/wp-content/uploads/2023/07/beurre-erable.jpg', 2.75, 26, 'CLEAR'),
(2, 'Beurre de fraises', 'Une description interessante qui donne envie d''acheter ce sirop qui me semble fort bon', 'https://www.sucrerieblouin.com/wp-content/uploads/2023/07/beurre-fraise.jpg', 4.5, 3, 'AMBER'),
(3, 'Bouteille avec feuille', 'Une description interessante qui donne envie d''acheter ce sirop qui me semble fort bon', 'https://www.sucrerieblouin.com/wp-content/uploads/2023/07/sirop-erable-bouteille-feuille.jpg', 5.25, 2, 'DARK'),
(4, 'Bouteille carrée', 'Une description interessante qui donne envie d''acheter ce sirop qui me semble fort bon', 'https://www.sucrerieblouin.com/wp-content/uploads/2023/07/sirop-erable-bouteille-carree.jpg', 6, 7, 'CLEAR'),
(5, 'Bouteille de plastique', 'Une description interessante qui donne envie d''acheter ce sirop qui me semble fort bon', 'https://www.sucrerieblouin.com/wp-content/uploads/2023/07/sirop-erable-bouteille-plastique.jpg', 4, 3, 'DARK')
;

insert into order_lines (id, quantity, product_id) VALUES
(1, 23, 1),
(2, 2, 2),
(3, 2, 3),
(4, 4, 4)
;
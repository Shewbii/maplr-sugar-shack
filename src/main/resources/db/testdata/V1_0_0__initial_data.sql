insert into products (id, name, description, image, price, stock, type) VALUES
(1, 'Beurre d’érable', '', 'https://www.sucrerieblouin.com/wp-content/uploads/2023/07/beurre-erable.jpg', 2.75, 26, 'CLEAR'),
(2, 'Beurre de fraises', '', 'https://www.sucrerieblouin.com/wp-content/uploads/2023/07/beurre-fraise.jpg', 4.5, 3, 'AMBER'),
(3, 'Bouteille avec feuille', '', 'https://www.sucrerieblouin.com/wp-content/uploads/2023/07/sirop-erable-bouteille-feuille.jpg', 5.25, 2, 'DARK'),
(4, 'Bouteille carrée', '', 'https://www.sucrerieblouin.com/wp-content/uploads/2023/07/sirop-erable-bouteille-carree.jpg', 6, 7, 'CLEAR'),
(5, 'Bouteille de plastique', '', 'https://www.sucrerieblouin.com/wp-content/uploads/2023/07/sirop-erable-bouteille-plastique.jpg', 4, 3, 'DARK')
;

insert into order_lines (quantity, product_id, order_id) VALUES
(23, 1, 1),
(2, 2, 1),
(2, 3, null),
(4, 4, null),
(1, 1, null)
;
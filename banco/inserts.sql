INSERT INTO cliente (id, email, nome) VALUES (1, 'a@a.com', 'Cliente A');
INSERT INTO cliente (id, email, nome) VALUES (2, 'b@b.com', 'Cliente B');
INSERT INTO cliente (id, email, nome) VALUES (3, 'c@c.com', 'Cliente C');

INSERT INTO produto (id, nome, valor) VALUES (1, 'Boné', 25);
INSERT INTO produto (id, nome, valor) VALUES (2, 'Bola', 120);
INSERT INTO produto (id, nome, valor) VALUES (3, 'Bermuda', 60);
INSERT INTO produto (id, nome, valor) VALUES (4, 'Camiseta', 80);
INSERT INTO produto (id, nome, valor) VALUES (5, 'Chuteira', 130);

INSERT INTO compra (id, data, quantidade, status, cliente_id, produto_id) VALUES (1, '2020-01-09 11:13:42', 10, 'OK', 1, 1);
INSERT INTO compra (id, data, quantidade, status, cliente_id, produto_id) VALUES (2, '2020-01-09 11:13:46', 20, 'OK', 1, 2);
INSERT INTO compra (id, data, quantidade, status, cliente_id, produto_id) VALUES (3, '2020-01-09 11:13:48', 30, 'OK', 1, 3);
INSERT INTO compra (id, data, quantidade, status, cliente_id, produto_id) VALUES (4, '2020-01-09 11:13:50', 40, 'OK', 1, 4);
INSERT INTO compra (id, data, quantidade, status, cliente_id, produto_id) VALUES (5, '2020-01-09 11:13:53', 50, 'OK', 1, 5);
-- Insertar clientes
INSERT INTO public.customer (id, email, name, phone) VALUES (1,'uncledavecode@gmail.com', 'Uncle Dave', '08123456789');
INSERT INTO public.customer (id, email, name, phone) VALUES (2,'udc@gmail.com', 'Uncle Dave Code', '213423423');

-- Insertar órdenes
INSERT INTO public.orders (id, customer_id, delivery_date, order_date, order_number, status) VALUES (1, 1, '2023-01-01 00:00:00', '2023-03-01 00:00:00', 'ORD-0001', 'DELIVERED');
INSERT INTO public.orders (id, customer_id, delivery_date, order_date, order_number, status) VALUES (2, 1, '2023-01-01 00:00:00', '2023-03-01 00:00:00', 'ORD-0002', 'DELIVERED');

-- Insertar productos
INSERT INTO public.product (id, price, code, description, name) VALUES (1, 5.0, 'PRD-0001', 'Product 1 Description', 'Product 1');
INSERT INTO public.product (id, price, code, description, name) VALUES (2, 15.0, 'PRD-0002', 'Product 2 Description', 'Product 2');

-- Insertar detalles de órdenes
INSERT INTO public.orderdetails (order_id, product_id, quantity, price, total) VALUES (1, 1, 1, 5.0, 5.0);
INSERT INTO public.orderdetails (order_id, product_id, quantity, price, total) VALUES (1, 2, 2, 15.0, 30.0);

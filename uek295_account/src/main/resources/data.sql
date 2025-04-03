-- Drop the foreign key constraint from the accounts table
ALTER TABLE accounts DROP CONSTRAINT IF EXISTS fk_customer;

DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
customer_id UUID PRIMARY KEY,
name VARCHAR(255) NOT NULL,
phone VARCHAR(20),
birthday DATE
);

CREATE TABLE accounts (
account_id UUID PRIMARY KEY,
email VARCHAR(255) NOT NULL UNIQUE,
password VARCHAR(255) NOT NULL,
created_at TIMESTAMP NOT NULL,
customer_id UUID,
CONSTRAINT fk_customer
FOREIGN KEY (customer_id)
REFERENCES customers(customer_id)
ON DELETE CASCADE
);




-- accounts andy
INSERT INTO customers (customer_id, name, phone, birthday)
VALUES ('67233580-4f7e-45ee-98fb-488b41ff51e1', 'andy landy', '7986435636688', '1985-03-15');

INSERT INTO accounts (account_id, email, password, created_at, customer_id)
VALUES ('1244993f-97d5-4f2b-b31a-36aa74166e6a', 'andysEmail@example.com', 'Andy_password',
        '2024-04-03T12:00:00', '67233580-4f7e-45ee-98fb-488b41ff51e1');


-- accounts for Nori
INSERT INTO customers (customer_id, name, phone, birthday)
VALUES ('170d1944-b20a-4b74-8d32-14afea98303b', 'Nori Nori', '123456789', '1990-05-15');

INSERT INTO accounts (account_id, email, password, created_at, customer_id)
VALUES ('222e4567-e89b-12d3-a456-426614174001', 'nori1@example.com', 'noriPassOne',
        '2024-04-03T12:00:00', '170d1944-b20a-4b74-8d32-14afea98303b'),
    ('333e4567-e89b-12d3-a456-426614174002', 'nori2@example.com', 'noriPasTwo',
     '2024-04-03T13:00:00', '170d1944-b20a-4b74-8d32-14afea98303b');


-- accounts for brad
INSERT INTO customers (customer_id, name, phone, birthday)
VALUES ('9724c26b-caef-4be3-b0b8-bfdebd0e3d25', 'Brad Bradington', '+417654321', '2000-08-02');

INSERT INTO accounts (account_id, email, password, created_at, customer_id)
VALUES
    ('4d9e4567-e89b-12d3-a456-426614174003', 'brad1@example.com', 'brad_password1',
     '2024-04-04T12:00:00', '9724c26b-caef-4be3-b0b8-bfdebd0e3d25');


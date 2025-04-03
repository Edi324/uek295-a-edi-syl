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




-- Insert Multiple Accounts for One Customer
INSERT INTO accounts (account_id, email, password, created_at, customer_id)
VALUES ('222e4567-e89b-12d3-a456-426614174001', 'Nori@example.com', 'cool_password', '2024-04-03T12:00:00', '111e4567-e89b-12d3-a456-426614174000');

INSERT INTO accounts (account_id, email, password, created_at, customer_id)
VALUES ('333e4567-e89b-12d3-a456-426614174002', 'john2@example.com', 'hashed_password2', '2024-04-03T13:00:00', '111e4567-e89b-12d3-a456-426614174000');

INSERT INTO customers (customer_id, name, phone, birthday)
VALUES ('8fdff6f7-f082-4074-af6b-c23db419e10a', 'Regular User', '+417654321', '1995-05-05');

INSERT INTO customers (customer_id, name, phone, birthday)
VALUES ('111e4567-e89b-12d3-a456-426614174000', 'Nori Nori', '123456789', '1990-05-15');
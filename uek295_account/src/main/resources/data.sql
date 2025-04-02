-- Clear only the tables that actually exist
DELETE FROM customers;
DELETE FROM accounts;

-- Insert test data
INSERT INTO accounts (account_id, email, password, created_at)
VALUES
('d0c387e6-9aa7-417c-b047-669f1ead2563', 'admin@noseryoung.ch', 'secure123', CURRENT_TIMESTAMP),
('f35c2dbf-18f4-4efd-8bb5-f802deb64215', 'user@noseryoung.ch', 'password123', CURRENT_TIMESTAMP);

INSERT INTO customers (customer_id, name, phone, birthday, account_id)
VALUES
('198e6ede-a2ca-4244-be67-0774d76183f5', 'Admin User', '+411234567', '1990-01-01', 'd0c387e6-9aa7-417c-b047-669f1ead2563'),
('8fdff6f7-f082-4074-af6b-c23db419e10a', 'Regular User', '+417654321', '1995-05-05', 'f35c2dbf-18f4-4efd-8bb5-f802deb64215');
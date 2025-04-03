# UK 295 - Backend Implementation  
Bookstore Account & Customer Management System  

---
# Backend Implementation for a Bookstore

## Overview

### General Requirements

- Implement a backend for a bookstore with a PostgreSQL database.
- Use a three-layer architecture (Controller, Service, Repository) with REST endpoints.
- Include error handling, validation, Swagger documentation, and tests (using Postman).
- Adhere to coding standards and commit regularly to the repository.

### Individual Requirements (Account - Customer)

#### Account
- Full backend component (Entity, Controller, Service, Repository) with CRUD endpoints (POST, GET, PUT, DELETE).
- Attributes: 
  - `account_id` (UUID)
  - `email`
  - `password`
  - `created_at`
  - `event_time`
  - etc.

#### Customer
- Backend component without a controller (no endpoints).
- Attributes:
  - `customer_id` (UUID)
  - `name`
  - `phone`
  - `birthday`
  - etc.

#### Relationship
- Determine the relationship between Account and Customer (e.g., one-to-one or many-to-one).

#### Filters
- Optional request parameters for the `GET ALL` endpoint (e.g., filter by name or include/exclude child entities).

### Additional Notes
- Do not add extensions without prior agreement. Implement the basic requirements first.
- Provide documentation in the `README` and Swagger.

# Summary of Endpoints for Account

### GET /accounts
- Returns a list of all accounts.

### GET /accounts/{account_id}
- Returns a specific account based on the `account_id` (UUID).

### PUT /accounts/{account_id}
- Updates an existing account (e.g., email, password).

### POST /accounts
- Creates a new account and associates it with an existing customer.

### DELETE /accounts/{account_id}
- Deletes an account based on the `account_id`.

### Notes:
- **Customer** is managed separately (without its own endpoints) and is referenced through the Account entity.
- Relationship: Likely **many-to-one** (customer can have multiple accountsr).

### Testing (Postman):
- Full CRUD operations for Account.
- Verify the relationship to Customer (e.g., whether POST requires a valid `customer_id`).

### Testing swagger:
![ANALYZE](https://github.com/Edi324/uek295-a-edi-syl/blob/main/swagger_test.png)


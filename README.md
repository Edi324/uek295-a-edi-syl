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

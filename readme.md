# Talabat Food Ordering System

A console-based food ordering application developed in Java using Object-Oriented Programming (OOP) concepts.
The system simulates a simplified version of a food delivery platform like Talabat, where customers can browse restaurants, place orders, track them, and admins can manage restaurants and customers.

---

## Features

### Customer Features

* Create a new account
* Sign in using username and password
* Browse restaurants
* View restaurant menus
* Place food orders
* Track existing orders
* Cancel orders
* Pay using:

  * Cash
  * Visa/Card

### Admin Features

* View all customers
* View all restaurants
* Add restaurants
* Edit restaurant information
* Add / remove / update dishes
* Edit customer information
* Remove customers

---

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Collections Framework (`ArrayList`)
* Java Time API (`LocalDateTime`, `YearMonth`)
* Stream API
* Console-based UI

---

## OOP Concepts Applied

* Encapsulation
* Inheritance
* Polymorphism
* Abstraction
* Composition

---

## Project Structure

```text
Talabat/
│
├── Main.java
├── SystemActions.java
│
├── User.java
├── Customer.java
├── Admin.java
│
├── Resturant.java
├── ResturantRepo.java
│
├── Dish.java
├── Category.java
│
├── Order.java
├── OrderItem.java
├── OrderStatus.java
│
├── Payment.java
│
├── CustomerRepo.java
│
├── Presentable.java
├── ConsolePresenter.java
```

---

## Main Classes Overview

### User

Abstract base class for all system users.

### Customer

Represents application customers and contains ordering functionality.

### Admin

Handles system management operations.

### Restaurant

Contains restaurant information and menu management.

### Dish

Represents menu items with:

* Name
* Description
* Category
* Price

### Order

Represents customer orders and delivery tracking.

### Payment

Handles cash and visa payment simulation.

---

## Sample Admin Credentials

```text
Username: ADMIN
Password: admin123
```

---

## Sample Workflow

### Customer Flow

1. Create account
2. Login
3. Select restaurant
4. Choose dishes
5. Confirm payment
6. Track order

### Admin Flow

1. Login as admin
2. Add/Edit restaurants
3. Manage dishes
4. View customers

---

## Validation Implemented

* Invalid menu selections handling
* Invalid numeric input handling
* Payment validation
* Rating validation
* Quantity validation
* Null checking

---

## Future Improvements

* GUI version using JavaFX or Swing
* Database integration (MySQL)
* Real payment gateway
* Delivery tracking simulation
* Save/load data from files
* Search and filtering
* Order history
* Multi-admin support

---

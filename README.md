# 🍽️ Menu Microservice Application

This project is a Spring Boot microservice designed to manage restaurant menus and provide intelligent food recommendations based on weather conditions. It is part of a distributed system that also includes an **Eureka Service Registry** and an **API Gateway** for centralized routing and discovery.

---

## 🧩 Microservice Architecture

### 🔹 Menu Service
- Manages CRUD operations for menu items.
- Fetches similar recipes and nutrition info using the Spoonacular API.
- Provides food suggestions based on current weather conditions using OpenWeatherMap API.

### 🔹 Eureka Server
- Registers microservices for service discovery.
- Allows dynamic scaling and robust communication.

### 🔹 API Gateway
- Routes client requests to the appropriate microservices.
- Handles cross-cutting concerns like logging, security, and CORS.

---

## ⚙️ Features

- ✅ Add, update, delete, and view menu items.
- ☁️ Fetch current weather data by city.
- 🍲 Suggest recipes based on weather (e.g. soups for rainy days, smoothies for sunny days).
- 🍽️ Retrieve similar recipes and nutritional information by dish name or ID.
- 🧠 Integrates with **Spoonacular** and **OpenWeatherMap** APIs.

---

## 🛠️ Technologies Used

- Spring Boot
- Spring Web
- Spring Cloud Eureka
- Spring Cloud Gateway
- RestTemplate
- H2 (or any database)
- JSON, HTTP, REST
- External APIs: Spoonacular & OpenWeatherMap

# 🍽️ Microservice de Gestion de Menus

Ce projet est un microservice Spring Boot conçu pour gérer les menus de restaurant et fournir des recommandations alimentaires intelligentes basées sur les conditions météorologiques. Il fait partie d’un système distribué qui comprend également un **registre de services Eureka** et une **passerelle API Gateway** pour le routage centralisé et la découverte des services.

---

## 🧩 Architecture Microservices

### 🔹 Service de Menu
- Gère les opérations CRUD sur les menus.
- Récupère des recettes similaires et des informations nutritionnelles via l’API Spoonacular.
- Fournit des suggestions alimentaires basées sur la météo actuelle grâce à l’API OpenWeatherMap.

### 🔹 Serveur Eureka
- Enregistre les microservices pour la découverte de services.
- Permet une communication robuste et un déploiement dynamique.

### 🔹 Passerelle API (API Gateway)
- Route les requêtes des clients vers les microservices appropriés.
- Gère les préoccupations transversales telles que les logs, la sécurité et CORS.

---

## ⚙️ Fonctionnalités

- ✅ Ajouter, modifier, supprimer et consulter des menus.
- ☁️ Récupérer les données météorologiques actuelles par ville.
- 🍲 Suggérer des recettes en fonction de la météo (ex : soupes pour les jours pluvieux, smoothies pour les jours ensoleillés).
- 🍽️ Obtenir des recettes similaires et des informations nutritionnelles par nom ou ID du plat.
- 🧠 Intégration avec les API **Spoonacular** et **OpenWeatherMap**.

---

## 🛠️ Technologies Utilisées

- Spring Boot  
- Spring Web  
- Spring Cloud Eureka  
- Spring Cloud Gateway  
- RestTemplate  
- H2 (ou toute autre base de données)  
- JSON, HTTP, REST  
- APIs externes : Spoonacular & OpenWeatherMap

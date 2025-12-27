<div align="center">

# 🚀 TP21 - Microservices Architecture

### *Service Discovery with Netflix Eureka, Spring Boot & Docker*

<br/>

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.1-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2023.0.0-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Netflix Eureka](https://img.shields.io/badge/Netflix-Eureka-E50914?style=for-the-badge&logo=netflix&logoColor=white)

<br/>

---

### 👨‍💻 **Developed by**

<a href="https://github.com/karzouz">
  <img src="https://img.shields.io/badge/Karzouz%20Saad-Developer-blueviolet?style=for-the-badge&logo=github&logoColor=white" alt="Karzouz Saad"/>
</a>

---

</div>

<br/>

## 📋 Table of Contents

<details open>
<summary><b>Click to expand/collapse</b></summary>

- [🎯 Project Overview](#-project-overview)
- [🏗️ Architecture](#️-architecture)
- [✨ Key Features](#-key-features)
- [🛠️ Technologies Used](#️-technologies-used)
- [📁 Project Structure](#-project-structure)
- [🚀 Getting Started](#-getting-started)
- [📸 Screenshots](#-screenshots)
- [🔌 API Endpoints](#-api-endpoints)
- [🧪 Testing the APIs](#-testing-the-apis)
- [📚 Key Concepts Learned](#-key-concepts-learned)
- [🐛 Troubleshooting](#-troubleshooting)

</details>

<br/>

---

## 🎯 Project Overview

<div align="center">

> *A hands-on practical project demonstrating microservices architecture with service discovery, inter-service communication, and database persistence.*

</div>

This project implements a **complete microservices ecosystem** with:

| Component | Description | Port |
|:---------:|:------------|:----:|
| 🌐 **Eureka Server** | Service Discovery & Registry | `8761` |
| 👥 **Service-Client** | Client Management Microservice | `8081` |
| 🚗 **Service-Car** | Car Management with Client Enrichment | `8082` |
| 🐬 **MySQL** | Database via Docker | `3306` |

<br/>

---

## 🏗️ Architecture

<div align="center">

```
┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
┃                    🌐 EUREKA SERVER (8761)                     ┃
┃                     Service Discovery Hub                      ┃
┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
                               ▲
                               │ Registration & Heartbeat
               ┌───────────────┴───────────────┐
               │                               │
               ▼                               ▼
┏━━━━━━━━━━━━━━━━━━━━━━━━━━┓   ┏━━━━━━━━━━━━━━━━━━━━━━━━━━┓
┃  👥 SERVICE-CLIENT (8081) ┃   ┃   🚗 SERVICE-CAR (8082)   ┃
┃  ━━━━━━━━━━━━━━━━━━━━━━━━ ┃   ┃  ━━━━━━━━━━━━━━━━━━━━━━━━ ┃
┃  • REST API for Clients   ┃◄──┃  • REST API for Cars      ┃
┃  • JPA + MySQL            ┃   ┃  • WebClient Integration  ┃
┃  • Auto-discovery         ┃   ┃  • Data Enrichment        ┃
┗━━━━━━━━━━━━━━━━━━━━━━━━━━┛   ┗━━━━━━━━━━━━━━━━━━━━━━━━━━┛
               │                               │
               ▼                               ▼
         ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓
         ┃              🐬 MySQL (Docker: 3306)             ┃
         ┃  ┌─────────────────┐   ┌─────────────────┐      ┃
         ┃  │ clientservicedb │   │  carservicedb   │      ┃
         ┃  └─────────────────┘   └─────────────────┘      ┃
         ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
```

</div>

<br/>

---

## ✨ Key Features

<table>
<tr>
<td width="50%">

### 🔍 Service Discovery
- Netflix Eureka Server
- Automatic service registration
- Health monitoring dashboard
- Real-time instance tracking

### 🔗 Inter-Service Communication
- WebClient with LoadBalancer
- Service name resolution
- Reactive HTTP calls
- Data enrichment pattern

</td>
<td width="50%">

### 💾 Data Persistence
- Spring Data JPA
- MySQL 8.0 with Docker
- Auto schema generation
- Separate databases per service

### 🛡️ Best Practices
- Clean architecture
- RESTful API design
- YAML configuration
- Docker containerization

</td>
</tr>
</table>

<br/>

---

## 🛠️ Technologies Used

<div align="center">

| Category | Technology | Version |
|:--------:|:----------:|:-------:|
| ☕ **Runtime** | Java | 17 |
| 🍃 **Framework** | Spring Boot | 3.2.1 |
| ☁️ **Cloud** | Spring Cloud | 2023.0.0 |
| 🔍 **Discovery** | Netflix Eureka | Latest |
| ⚖️ **Load Balancing** | Spring Cloud LoadBalancer | Latest |
| 🌊 **HTTP Client** | Spring WebFlux (WebClient) | Latest |
| 💾 **Database** | MySQL | 8.0 |
| 🐳 **Container** | Docker Compose | Latest |
| 📦 **Build** | Maven | 3.9.x |

</div>

<br/>

---

## 📁 Project Structure

```
tp21/
│
├── 📄 docker-compose.yml          # 🐳 Docker MySQL configuration
├── 📄 init-db.sql                 # 🗃️ Database initialization script
├── 📄 README.md                   # 📖 This documentation
│
├── 📂 eureka-server/              # 🌐 Discovery Server (Port 8761)
│   ├── pom.xml
│   └── src/main/
│       ├── java/.../EurekaServerApplication.java
│       └── resources/application.yml
│
├── 📂 service-client/             # 👥 Client Microservice (Port 8081)
│   ├── pom.xml
│   └── src/main/
│       ├── java/.../
│       │   ├── ServiceClientApplication.java
│       │   ├── entities/Client.java
│       │   ├── repositories/ClientRepository.java
│       │   └── web/ClientController.java
│       └── resources/application.yml
│
├── 📂 service-car/                # 🚗 Car Microservice (Port 8082)
│   ├── pom.xml
│   └── src/main/
│       ├── java/.../
│       │   ├── ServiceCarApplication.java
│       │   ├── config/WebClientConfig.java    # ⚡ @LoadBalanced
│       │   ├── entities/
│       │   │   ├── Car.java
│       │   │   └── Client.java (DTO)
│       │   ├── repositories/CarRepository.java
│       │   ├── services/ClientApi.java        # 🔗 WebClient
│       │   └── web/
│       │       ├── CarController.java
│       │       └── TestController.java
│       └── resources/application.yml
│
└── 📂 Screenshots/                # 📸 Project Screenshots
```

<br/>

---

## 🚀 Getting Started

### Prerequisites

<div align="center">

| Requirement | Version |
|:-----------:|:-------:|
| ☕ Java JDK | 17+ |
| 📦 Maven | 3.9+ |
| 🐳 Docker | Latest |
| 🔧 Docker Compose | Latest |

</div>

### ⚡ Quick Start

#### Step 1️⃣ - Start MySQL Database

```powershell
# Navigate to project directory
cd tp21

# Start MySQL container
docker-compose up -d

# Verify MySQL is running
docker ps
```

<div align="center">

![Docker MySQL Running](Screenshots/Screenshot%202025-12-27%20132217.png)

*✅ MySQL Docker Container Started Successfully*

</div>

---

#### Step 2️⃣ - Start Eureka Server (Port 8761)

```powershell
cd eureka-server
mvn spring-boot:run
```

<div align="center">

![Eureka Server Started](Screenshots/Screenshot%202025-12-27%20132233.png)

*✅ Eureka Server Running on Port 8761*

</div>

---

#### Step 3️⃣ - Start Service-Client (Port 8081)

```powershell
cd service-client
mvn spring-boot:run
```

<div align="center">

![Service Client Started](Screenshots/Screenshot%202025-12-27%20132248.png)

*✅ Service-Client Running & Registered in Eureka*

</div>

---

#### Step 4️⃣ - Start Service-Car (Port 8082)

```powershell
cd service-car
mvn spring-boot:run
```

<div align="center">

![Service Car Started](Screenshots/Screenshot%202025-12-27%20132302.png)

*✅ Service-Car Running & Registered in Eureka*

</div>

---

## 📸 Screenshots

### 🌐 Eureka Dashboard - All Services Registered

<div align="center">

![Eureka Dashboard](Screenshots/Screenshot%202025-12-27%20132319.png)

*The Eureka Dashboard showing both **SERVICE-CLIENT** and **SERVICE-CAR** registered and UP*

</div>

---

### 🧪 API Testing Results

<div align="center">

![API Testing](Screenshots/Screenshot%202025-12-27%20132355.png)

*Testing the Car API with Client Enrichment - Full Integration Working*

</div>

<br/>

---

## 🔌 API Endpoints

### 🌐 Eureka Server (Port 8761)

| Endpoint | Description |
|:--------:|:------------|
| `http://localhost:8761` | 📊 Eureka Dashboard |

---

### 👥 Service-Client (Port 8081)

| Method | Endpoint | Description |
|:------:|:---------|:------------|
| `GET` | `/api/clients` | 📋 List all clients |
| `GET` | `/api/clients/{id}` | 🔍 Get client by ID |
| `POST` | `/api/clients` | ➕ Create new client |
| `PUT` | `/api/clients/{id}` | ✏️ Update client |
| `DELETE` | `/api/clients/{id}` | 🗑️ Delete client |

---

### 🚗 Service-Car (Port 8082)

| Method | Endpoint | Description |
|:------:|:---------|:------------|
| `GET` | `/api/cars` | 📋 List all cars (with client info) |
| `GET` | `/api/cars/{id}` | 🔍 Get car by ID (enriched) |
| `GET` | `/api/cars/byClient/{id}` | 🔎 Get cars by client ID |
| `POST` | `/api/cars` | ➕ Create new car |
| `PUT` | `/api/cars/{id}` | ✏️ Update car |
| `DELETE` | `/api/cars/{id}` | 🗑️ Delete car |
| `GET` | `/api/test/client/{id}` | 🧪 Test WebClient call |

<br/>

---

## 🧪 Testing the APIs

### 1️⃣ Create a Client

```powershell
Invoke-RestMethod -Method POST `
  -Uri "http://localhost:8081/api/clients" `
  -ContentType "application/json" `
  -Body '{"nom": "Salma", "age": 22}'
```

**Response:**
```json
{
  "id": 1,
  "nom": "Salma",
  "age": 22.0
}
```

---

### 2️⃣ Create a Car

```powershell
Invoke-RestMethod -Method POST `
  -Uri "http://localhost:8082/api/cars" `
  -ContentType "application/json" `
  -Body '{"marque": "Toyota", "modele": "Yaris", "clientId": 1}'
```

---

### 3️⃣ Get Cars with Enriched Client Data ⭐

```powershell
Invoke-RestMethod -Uri "http://localhost:8082/api/cars" | ConvertTo-Json -Depth 5
```

**Response (with enrichment):**
```json
[
  {
    "id": 1,
    "marque": "Toyota",
    "modele": "Yaris",
    "clientId": 1,
    "client": {
      "id": 1,
      "nom": "Salma",
      "age": 22.0
    }
  }
]
```

<br/>

---

## 📚 Key Concepts Learned

<div align="center">

| Concept | Annotation/Feature | Purpose |
|:-------:|:------------------:|:--------|
| 🌐 | `@EnableEurekaServer` | Activates Eureka Discovery Server |
| 🔍 | `@EnableDiscoveryClient` | Registers service with Eureka |
| ⚖️ | `@LoadBalanced` | Enables service name resolution |
| 📭 | `@Transient` | Excludes field from JPA persistence |
| 🌊 | `WebClient` | Non-blocking HTTP client |
| 📝 | `application.yml` | YAML-based configuration |

</div>

### 🎯 Data Enrichment Pattern

```
┌──────────────────────────────────────────────────────────────┐
│                    SERVICE-CAR Request Flow                   │
├──────────────────────────────────────────────────────────────┤
│  1. Client requests GET /api/cars                            │
│  2. CarController fetches cars from local DB (carservicedb)  │
│  3. For each car, WebClient calls SERVICE-CLIENT             │
│  4. Client data is attached to car (@Transient field)        │
│  5. Enriched response returned to client                     │
└──────────────────────────────────────────────────────────────┘
```

<br/>

---

## 🐛 Troubleshooting

<details>
<summary><b>❌ "No instances available for SERVICE-CLIENT"</b></summary>

**Causes:**
- Missing `@LoadBalanced` on `WebClient.Builder`
- Missing `spring-cloud-starter-loadbalancer` dependency
- SERVICE-CLIENT not registered in Eureka

**Solutions:**
1. Verify `@LoadBalanced` annotation in `WebClientConfig.java`
2. Check `pom.xml` for LoadBalancer dependency
3. Ensure SERVICE-CLIENT is visible in Eureka Dashboard

</details>

<details>
<summary><b>❌ MySQL Connection Refused</b></summary>

**Causes:**
- Docker MySQL not running
- Wrong password in configuration

**Solutions:**
```powershell
# Check if container is running
docker ps

# Restart MySQL
docker-compose down
docker-compose up -d

# Check logs
docker logs mysql-microservices
```

</details>

<details>
<summary><b>❌ Port Already in Use</b></summary>

**Solution:**
Change the port in the respective `application.yml` file.

</details>

<br/>

---

<div align="center">

## 📊 Project Status

| Component | Status |
|:---------:|:------:|
| Eureka Server | ✅ Complete |
| Service-Client | ✅ Complete |
| Service-Car | ✅ Complete |
| WebClient Integration | ✅ Complete |
| Docker MySQL | ✅ Complete |
| Documentation | ✅ Complete |

<br/>

---

### 🌟 Made with ❤️ by **Karzouz Saad**

<br/>

![Made with Love](https://img.shields.io/badge/Made%20with-Love-ff69b4?style=for-the-badge&logo=heart)
![Spring Boot](https://img.shields.io/badge/Powered%20by-Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot)

<br/>

*© 2025 - TP21 Microservices Project*

</div>

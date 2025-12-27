package com.example.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Service Car Application
 * 
 * @EnableDiscoveryClient permet l'enregistrement automatique dans Eureka.
 *                        Ce service gère les voitures et communique avec
 *                        SERVICE-CLIENT via WebClient.
 * 
 *                        Endpoints:
 *                        - GET /api/cars : Liste toutes les voitures (enrichies
 *                        avec client)
 *                        - GET /api/cars/{id} : Récupère une voiture par ID
 *                        - GET /api/cars/byClient/{id} : Récupère les voitures
 *                        d'un client
 *                        - POST /api/cars : Crée une nouvelle voiture
 *                        - GET /api/test/client/{id} : Test de communication
 *                        avec SERVICE-CLIENT
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCarApplication.class, args);
    }
}

package com.example.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Service Client Application
 * 
 * @EnableDiscoveryClient permet l'enregistrement automatique dans Eureka.
 *                        Ce service gère les clients et expose une API REST.
 * 
 *                        Endpoints:
 *                        - GET /api/clients : Liste tous les clients
 *                        - GET /api/clients/{id} : Récupère un client par ID
 *                        - POST /api/clients : Crée un nouveau client
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceClientApplication.class, args);
    }
}

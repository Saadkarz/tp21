package com.example.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka Server Application
 * 
 * @EnableEurekaServer active le rôle "serveur de découverte"
 * Ce serveur permet aux microservices de s'enregistrer et de se découvrir mutuellement.
 * 
 * Dashboard accessible sur : http://localhost:8761
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}

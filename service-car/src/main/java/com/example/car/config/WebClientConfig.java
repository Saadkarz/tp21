package com.example.car.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuration WebClient avec Load Balancer
 * 
 * @LoadBalanced est CRUCIAL pour permettre l'appel par nom de service Eureka.
 * 
 *               Sans @LoadBalanced :
 *               - Spring ne sait pas résoudre "SERVICE-CLIENT"
 *               - Erreur typique : "No instances available for SERVICE-CLIENT"
 * 
 *               Avec @LoadBalanced :
 *               - On peut écrire : http://SERVICE-CLIENT/api/clients/1
 *               - Spring Cloud LoadBalancer résout le nom Eureka vers l'IP:port
 *               réel
 *               - Supporte aussi le load balancing si plusieurs instances
 *               existent
 */
@Configuration
public class WebClientConfig {

    /**
     * Crée un WebClient.Builder avec support du Load Balancing.
     * 
     * @return WebClient.Builder configuré pour résoudre les noms Eureka
     */
    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}

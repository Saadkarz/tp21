package com.example.car.services;

import com.example.car.entities.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

/**
 * Service d'appel HTTP vers SERVICE-CLIENT via WebClient
 * 
 * Utilise le nom Eureka "SERVICE-CLIENT" au lieu de l'IP:port directement.
 * Grâce à @LoadBalanced sur WebClient.Builder, Spring résout automatiquement
 * le nom Eureka vers l'instance disponible.
 * 
 * Flux d'exécution :
 * 1. build() : crée un WebClient concret
 * 2. get() : prépare une requête HTTP GET
 * 3. uri(...) : URL logique avec nom Eureka
 * 4. retrieve() : exécute l'appel et prépare la lecture
 * 5. bodyToMono(...) : réponse attendue = 1 objet Client
 * 6. block() : attend la réponse (bloquant) - simple pour TP
 * 
 * Note : block() est utilisé ici pour simplifier. En production,
 * on préférerait une approche réactive complète avec Mono/Flux.
 */
@Service
public class ClientApi {

    private static final Logger logger = LoggerFactory.getLogger(ClientApi.class);
    private static final String SERVICE_CLIENT_URL = "http://SERVICE-CLIENT/api/clients/";

    private final WebClient.Builder builder;

    public ClientApi(WebClient.Builder builder) {
        this.builder = builder;
    }

    /**
     * Récupère un client par son ID depuis SERVICE-CLIENT.
     * 
     * @param id L'identifiant du client
     * @return Le client trouvé ou null si non trouvé/erreur
     */
    public Client findClientById(Long id) {
        try {
            logger.info("Appel vers SERVICE-CLIENT pour récupérer le client ID: {}", id);

            Client client = builder.build()
                    .get()
                    .uri(SERVICE_CLIENT_URL + id)
                    .retrieve()
                    .bodyToMono(Client.class)
                    .block();

            logger.info("Client récupéré avec succès: {}", client);
            return client;

        } catch (WebClientResponseException.NotFound e) {
            logger.warn("Client ID {} non trouvé dans SERVICE-CLIENT", id);
            return null;
        } catch (Exception e) {
            logger.error("Erreur lors de l'appel à SERVICE-CLIENT: {}", e.getMessage());
            return null;
        }
    }
}

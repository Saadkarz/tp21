package com.example.car.web;

import com.example.car.entities.Client;
import com.example.car.services.ClientApi;
import org.springframework.web.bind.annotation.*;

/**
 * Controller de Test pour valider la communication avec SERVICE-CLIENT
 * 
 * Cet endpoint permet de tester que WebClient fonctionne correctement
 * avec le LoadBalancer et la résolution de nom Eureka.
 * 
 * Usage :
 * 1. Créer un client dans service-client (POST
 * http://localhost:8081/api/clients)
 * 2. Noter l'ID retourné (ex: 1)
 * 3. Appeler : GET http://localhost:8082/api/test/client/1
 * 4. Vérifier que le client est retourné correctement
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    private final ClientApi clientApi;

    public TestController(ClientApi clientApi) {
        this.clientApi = clientApi;
    }

    /**
     * Test de récupération d'un client depuis SERVICE-CLIENT
     * 
     * @param id L'identifiant du client à récupérer
     * @return Le client JSON depuis SERVICE-CLIENT
     */
    @GetMapping("/client/{id}")
    public Client testClient(@PathVariable Long id) {
        return clientApi.findClientById(id);
    }
}

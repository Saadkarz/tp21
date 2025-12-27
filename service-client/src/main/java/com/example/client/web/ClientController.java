package com.example.client.web;

import com.example.client.entities.Client;
import com.example.client.repositories.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST pour les Clients
 * 
 * @RestController : réponses JSON automatiques
 *                 @RequestMapping("/api/clients") : base URL pour toutes les
 *                 opérations
 * 
 *                 Endpoints disponibles :
 *                 - GET /api/clients : Liste tous les clients
 *                 - GET /api/clients/{id} : Récupère un client par ID
 *                 - POST /api/clients : Crée un nouveau client
 *                 - PUT /api/clients/{id} : Met à jour un client existant
 *                 - DELETE /api/clients/{id} : Supprime un client
 */
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientRepository repo;

    // Injection par constructeur (recommandée)
    public ClientController(ClientRepository repo) {
        this.repo = repo;
    }

    /**
     * Récupère tous les clients
     * GET /api/clients
     */
    @GetMapping
    public List<Client> findAll() {
        return repo.findAll();
    }

    /**
     * Récupère un client par son ID
     * GET /api/clients/{id}
     * 
     * @param id L'identifiant du client
     * @return Le client trouvé ou null si non trouvé
     */
    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return repo.findById(id)
                .map(client -> ResponseEntity.ok(client))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Crée un nouveau client
     * POST /api/clients
     * 
     * @RequestBody lit le JSON → objet Java → sauvegarde → JSON retour
     */
    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client) {
        Client savedClient = repo.save(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    /**
     * Met à jour un client existant
     * PUT /api/clients/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        return repo.findById(id)
                .map(existingClient -> {
                    existingClient.setNom(client.getNom());
                    existingClient.setAge(client.getAge());
                    return ResponseEntity.ok(repo.save(existingClient));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Supprime un client
     * DELETE /api/clients/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

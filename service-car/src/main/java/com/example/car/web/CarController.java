package com.example.car.web;

import com.example.car.entities.Car;
import com.example.car.repositories.CarRepository;
import com.example.car.services.ClientApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST pour les Voitures
 * 
 * Pattern d'enrichissement :
 * - CarController lit d'abord sa DB locale (carservicedb)
 * - Puis appelle SERVICE-CLIENT pour compléter la réponse JSON
 * - Le JSON final devient "agrégé" (car + client)
 * 
 * Endpoints disponibles :
 * - GET /api/cars : Liste toutes les voitures (enrichies)
 * - GET /api/cars/{id} : Récupère une voiture par ID (enrichie)
 * - GET /api/cars/byClient/{id} : Récupère les voitures d'un client
 * - POST /api/cars : Crée une nouvelle voiture
 * - PUT /api/cars/{id} : Met à jour une voiture
 * - DELETE /api/cars/{id} : Supprime une voiture
 */
@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarRepository repo;
    private final ClientApi clientApi;

    public CarController(CarRepository repo, ClientApi clientApi) {
        this.repo = repo;
        this.clientApi = clientApi;
    }

    /**
     * Récupère toutes les voitures avec enrichissement client
     * GET /api/cars
     * 
     * Pour chaque voiture, on récupère les infos du client associé
     * depuis SERVICE-CLIENT et on les ajoute à la réponse JSON.
     */
    @GetMapping
    public List<Car> findAll() {
        List<Car> cars = repo.findAll();

        // Enrichissement : pour chaque voiture, récupérer le client
        for (Car car : cars) {
            if (car.getClientId() != null) {
                car.setClient(clientApi.findClientById(car.getClientId()));
            }
        }
        return cars;
    }

    /**
     * Récupère une voiture par ID avec enrichissement client
     * GET /api/cars/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id) {
        return repo.findById(id)
                .map(car -> {
                    if (car.getClientId() != null) {
                        car.setClient(clientApi.findClientById(car.getClientId()));
                    }
                    return ResponseEntity.ok(car);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Récupère toutes les voitures d'un client spécifique
     * GET /api/cars/byClient/{clientId}
     * 
     * Utilise la méthode dérivée findByClientId du repository
     */
    @GetMapping("/byClient/{clientId}")
    public List<Car> findByClient(@PathVariable Long clientId) {
        List<Car> cars = repo.findByClientId(clientId);

        // Même client pour toutes les voitures de ce clientId
        // Optimisation : on appelle une seule fois le service client
        if (!cars.isEmpty()) {
            var client = clientApi.findClientById(clientId);
            for (Car car : cars) {
                car.setClient(client);
            }
        }
        return cars;
    }

    /**
     * Crée une nouvelle voiture
     * POST /api/cars
     * 
     * Body JSON attendu :
     * { "marque": "Toyota", "modele": "Yaris", "clientId": 1 }
     */
    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car) {
        // Sauvegarde uniquement la voiture (DB locale carservicedb)
        Car savedCar = repo.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }

    /**
     * Met à jour une voiture existante
     * PUT /api/cars/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@PathVariable Long id, @RequestBody Car car) {
        return repo.findById(id)
                .map(existingCar -> {
                    existingCar.setMarque(car.getMarque());
                    existingCar.setModele(car.getModele());
                    existingCar.setClientId(car.getClientId());
                    return ResponseEntity.ok(repo.save(existingCar));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Supprime une voiture
     * DELETE /api/cars/{id}
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

package com.example.car.repositories;

import com.example.car.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository Car
 * 
 * JpaRepository fournit les méthodes CRUD de base.
 * 
 * Méthode dérivée personnalisée :
 * - findByClientId(Long clientId) : Spring Data génère automatiquement
 * la requête SQL : SELECT * FROM cars WHERE client_id = ?
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    /**
     * Trouve toutes les voitures appartenant à un client spécifique.
     * 
     * @param clientId L'identifiant du client
     * @return Liste des voitures du client
     */
    List<Car> findByClientId(Long clientId);
}

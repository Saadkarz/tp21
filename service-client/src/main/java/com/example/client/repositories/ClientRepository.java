package com.example.client.repositories;

import com.example.client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository Client
 * 
 * JpaRepository fournit directement les méthodes CRUD :
 * - findAll() : récupère tous les clients
 * - findById(id) : récupère un client par son ID
 * - save(client) : sauvegarde un client (création ou mise à jour)
 * - deleteById(id): supprime un client par son ID
 * - count() : compte le nombre de clients
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // Les méthodes de base sont déjà fournies par JpaRepository
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
    // Exemple : List<Client> findByNom(String nom);
}

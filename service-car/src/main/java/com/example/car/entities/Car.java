package com.example.car.entities;

import jakarta.persistence.*;

/**
 * Entité Car
 * 
 * @Entity : mappe cette classe vers une table MySQL "cars"
 * 
 *         Champs :
 *         - id : identifiant unique auto-généré
 *         - marque : marque de la voiture (ex: Toyota)
 *         - modele : modèle de la voiture (ex: Yaris)
 *         - clientId : référence vers le client (stockée localement, pas de
 *         relation JPA)
 *         - client : objet client enrichi via WebClient (non persisté en DB)
 */
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String marque;

    @Column(nullable = false)
    private String modele;

    // Référence vers le client (stockée localement dans la DB)
    private Long clientId;

    // Non persisté : sert à renvoyer (car + client) dans la réponse JSON
    // @Transient indique que ce champ ne doit pas être sauvegardé en DB
    @Transient
    private Client client;

    // Constructeur vide obligatoire pour JPA/Hibernate
    public Car() {
    }

    // Constructeur avec paramètres
    public Car(Long id, String marque, String modele, Long clientId) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.clientId = clientId;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", clientId=" + clientId +
                ", client=" + client +
                '}';
    }
}

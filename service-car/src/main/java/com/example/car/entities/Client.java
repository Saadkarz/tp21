package com.example.car.entities;

/**
 * DTO Client (Data Transfer Object)
 * 
 * Ce DTO sert uniquement à "mapper" le JSON reçu depuis SERVICE-CLIENT.
 * Il n'est pas persisté en base de données.
 * 
 * Pattern microservices : on ne partage pas les entités JPA entre services.
 * Chaque service a sa propre représentation des données externes.
 */
public class Client {

    private Long id;
    private String nom;
    private Float age;

    // Constructeur vide (nécessaire pour la désérialisation JSON)
    public Client() {
    }

    // Constructeur avec paramètres
    public Client(Long id, String nom, Float age) {
        this.id = id;
        this.nom = nom;
        this.age = age;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                '}';
    }
}

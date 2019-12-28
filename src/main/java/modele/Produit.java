package modele;

import javax.persistence.*;

@Entity
public class Produit {

    //============================= Attributs =============================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduit;

    private String nomProduit;
    private int stock;
    private int reservations;
    private int prix;

    //============================= Constructeurs =============================



    //============================= Getters et Setters =============================
}
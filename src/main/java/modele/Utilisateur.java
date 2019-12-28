package modele;

import javax.persistence.*;

@Entity
public class Utilisateur {

    //============================= Attributs =============================

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUtilisateur;

    private String nomDeCompte;
    private String nom;
    private String prenom;
    private String motDePasse;
    private TypeDeCompte typeDeCompte;
    private boolean restreint;

    //idMagasin

    //idRayon

    //Utilisé pour magasin.chefDeMagasin
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Magasin magasinDirige;

    //============================= Constructeurs =============================



    //============================= Getters et Setters =============================


}
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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "rayon")
    private Rayon rayon;

    //============================= Constructeurs =============================

    public Produit(String nomProduit, int stock, int reservations, int prix, Rayon rayon) {
        this.nomProduit = nomProduit;
        this.stock = stock;
        this.reservations = reservations;
        this.prix = prix;
        this.rayon = rayon;
    }

    public Produit() {
        idProduit = -1;
        nomProduit = "";
        stock = 0;
        reservations = 0;
        prix = 0;
        rayon = null;
    }

    //============================= Méthodes ============================

    public boolean reservation(int quantite){
        if( quantite < stock - reservations ){
            reservations += quantite;
            return true;
        }
        return false;
    }

    public boolean suppression(int quantite){
        if( quantite < stock - reservations ){
            stock -= quantite;
            return true;
        }
        return false;
    }

    //============================= Getters et Setters =============================

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getReservations() {
        return reservations;
    }

    public void setReservations(int reservations) {
        this.reservations = reservations;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        this.rayon = rayon;
    }
}